/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package infraestructura.persistencia;

import aplicacion.IUsuarioRepository;
import java.sql.Connection;
import dominio.RolUsuario;
import dominio.Usuario;
import dominio.Trabajador;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author lanch
 */
public class MySQLUsuarioRepository implements IUsuarioRepository{
    @Override
    public void guardar(Usuario u) {
        String sql = "INSERT INTO Usuarios (usuario, hashContrasena, rol, dni, activo) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, u.getUsuario());
            ps.setString(2, u.getHashContrasena());
            ps.setString(3, u.getRol().name());
            ps.setString(4, u.getDni());
            ps.setBoolean(5, u.getActivo());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Usuario encontrarPorUsuario(String usuario) {
        String sql = "SELECT u.*, t.nombres, t.apellidos, t.turno, t.cargo " +
                     "FROM Usuarios u " +
                     "LEFT JOIN Trabajadores t ON u.dni = t.dni " +
                     "WHERE u.usuario = ?";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, usuario);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Trabajador trabajador = null;
                    if (rs.getString("dni") != null) {
                        trabajador = new Trabajador(
                            rs.getString("dni"),
                            rs.getString("nombres"),
                            rs.getString("apellidos"),
                            rs.getString("turno"),
                            rs.getString("cargo")
                        );
                    }
                    return new Usuario(
                        rs.getString("usuario"),
                        rs.getString("hashContrasena"),
                        RolUsuario.valueOf(rs.getString("rol")),
                        rs.getString("dni"),
                        rs.getBoolean("activo"),
                        trabajador
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
