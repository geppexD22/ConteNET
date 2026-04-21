/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package infraestructura.persistencia;

import aplicacion.IContenedorRepository;
import dominio.Contenedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lanch
 */
public class MySQLContenedorRepository implements IContenedorRepository{
    
    @Override
    public void guardar(Contenedor c) {
        String sql = "INSERT INTO Contenedores (idContenedor, descripcion, estadoOperativo, direccion, latitudA, longitudA) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, c.getIdContenedor());
            ps.setString(2, c.getDescripcion());
            ps.setString(3, c.getEstadoOperativo());
            ps.setString(4, c.getDireccion());
            ps.setDouble(5, c.getLatitudA());
            ps.setDouble(6, c.getLongitudA());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public List<Contenedor> encontrarTodos() {
        List<Contenedor> lista = new ArrayList<>();
        String sql = "SELECT * FROM Contenedores";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Contenedor(
                    rs.getString("idContenedor"),
                    rs.getString("descripcion"),
                    rs.getString("estadoOperativo"),
                    rs.getString("direccion"),
                    rs.getDouble("latitudA"),
                    rs.getDouble("longitudA")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    @Override
    public Contenedor encontrarPorId(String id) {
        String sql = "SELECT * FROM Contenedores WHERE idContenedor = ?";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Contenedor(
                        rs.getString("idContenedor"),
                        rs.getString("descripcion"),
                        rs.getString("estadoOperativo"),
                        rs.getString("direccion"),
                        rs.getDouble("latitudA"),
                        rs.getDouble("longitudA")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
