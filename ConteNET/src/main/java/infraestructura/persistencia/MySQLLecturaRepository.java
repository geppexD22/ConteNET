/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package infraestructura.persistencia;

import aplicacion.ILecturaRepository;
import dominio.LecturaContenedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lanch
 */
public class MySQLLecturaRepository implements ILecturaRepository{
    
    @Override
    public void guardar(LecturaContenedor l) {
        String sql = "INSERT INTO LecturasContenedor (idContenedor, nivel, capacidad, puerta, latitud, longitud, peso, fecha) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection conn = DatabaseConnection.getInstance().getConnection();

            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, l.getIdContenedor());
                ps.setInt(2, l.getNivel());
                ps.setString(3, l.getCapacidad());
                ps.setString(4, l.getPuerta());
                ps.setDouble(5, l.getLatitud());
                ps.setDouble(6, l.getLongitud());
                ps.setDouble(7, l.getPeso());
                ps.setTimestamp(8, Timestamp.valueOf(l.getFecha()));

                ps.executeUpdate();
            }
        } catch (SQLException e) {
            System.err.println("Error en la base de datos: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public List<LecturaContenedor> encontrarTodos(String idContenedor) {
        List<LecturaContenedor> lista = new ArrayList<>();
        String sql = "SELECT * FROM LecturasContenedor WHERE idContenedor = ? ORDER BY fecha DESC";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, idContenedor);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    lista.add(new LecturaContenedor(
                        rs.getLong("idLectura"),
                        rs.getString("idContenedor"),
                        rs.getInt("nivel"),
                        rs.getString("capacidad"),
                        rs.getString("puerta"),
                        rs.getDouble("latitud"),
                        rs.getDouble("longitud"),
                        rs.getDouble("peso"),
                        rs.getTimestamp("fecha").toLocalDateTime()
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public LecturaContenedor encontrarUltima(String idContenedor) {
        String sql = "SELECT * FROM LecturasContenedor WHERE idContenedor = ? ORDER BY fecha DESC LIMIT 1";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, idContenedor);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new LecturaContenedor(
                        rs.getLong("idLectura"),
                        rs.getString("idContenedor"),
                        rs.getInt("nivel"),
                        rs.getString("capacidad"),
                        rs.getString("puerta"),
                        rs.getDouble("latitud"),
                        rs.getDouble("longitud"),
                        rs.getDouble("peso"),
                        rs.getTimestamp("fecha").toLocalDateTime()
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
