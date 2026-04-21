/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author edgar
 */
public class Trabajador {
    
    private String dni;
    private String nombres;
    private String apellidos;
    private String turno;
    private String cargo;

    public Trabajador(String dni, String nombres, String apellidos, String turno, String cargo) {
        this.dni = dni;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.turno = turno;
        this.cargo = cargo;
    }

    public String getDni() {
        return dni;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getTurno() {
        return turno;
    }

    public String getCargo() {
        return cargo;
    }
    
    
}
