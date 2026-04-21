/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.time.LocalDateTime;

/**
 *
 * @author edgar
 */
public class LecturaContenedor {
    
    private long idLectura;
    private String idContenedor;
    private int nivel;
    private String capacidad;
    private String puerta;
    private Double latitud;
    private Double longitud;
    private Double peso;
    private LocalDateTime fecha;

    public LecturaContenedor(String idContenedor, int nivel, String capacidad, String puerta, Double latitud, Double longitud, Double peso) {
        this.idContenedor = idContenedor;
        this.nivel = nivel;
        this.capacidad = capacidad;
        this.puerta = puerta;
        this.latitud = latitud;
        this.longitud = longitud;
        this.peso = peso;
        this.fecha = LocalDateTime.now();
    }
    
    public LecturaContenedor(long idLectura, String idContenedor, int nivel, String capacidad, String puerta, Double latitud, Double longitud, Double peso, LocalDateTime fecha) {
        this.idLectura = idLectura;
        this.idContenedor = idContenedor;
        this.nivel = nivel;
        this.capacidad = capacidad;
        this.puerta = puerta;
        this.latitud = latitud;
        this.longitud = longitud;
        this.peso = peso;
        this.fecha = fecha;
    }

    public long getIdLectura() {
        return idLectura;
    }

    public String getIdContenedor() {
        return idContenedor;
    }

    public int getNivel() {
        return nivel;
    }

    public String getCapacidad() {
        return capacidad;
    }

    public String getPuerta() {
        return puerta;
    }

    public Double getLatitud() {
        return latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public Double getPeso() {
        return peso;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }
    
    public boolean esNivelCritico() {
        return this.nivel <= 4; 
    }
}
