/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author edgar
 */
public class Usuario {
    
    private String usuario;
    private String hashContrasena;
    private RolUsuario rol;
    private String dni;
    private Boolean activo;
    private Trabajador trabajador;

    public Usuario(String usuario, String hashContrasena, RolUsuario rol, String dni, Trabajador trabajador) {
        this.usuario = usuario;
        this.hashContrasena = hashContrasena;
        this.rol = rol;
        this.dni = dni;
        this.trabajador = trabajador;
        this.activo = true;
    }

    public Usuario(String usuario, String hashContrasena, RolUsuario rol, String dni, Boolean activo, Trabajador trabajador) {
        this.usuario = usuario;
        this.hashContrasena = hashContrasena;
        this.rol = rol;
        this.dni = dni;
        this.activo = activo;
        this.trabajador = trabajador;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getHashContrasena() {
        return hashContrasena;
    }

    public RolUsuario getRol() {
        return rol;
    }

    public String getDni() {
        return dni;
    }

    public Boolean getActivo() {
        return activo;
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }
    
    public boolean esEmpleado(){
        return this.trabajador != null;
    }
}
