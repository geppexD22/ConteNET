/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author edgar
 */
public class Contenedor {
    
    private String idContenedor;
    private String descripcion;
    private String estadoOperativo;
    private String direccion;
    private Double latitudA;
    private Double longitudA;

    public Contenedor(String idContenedor, String descripcion, String estadoOperativo, String direccion, Double latitudA, Double longitudA) {
        this.idContenedor = idContenedor;
        this.descripcion = descripcion;
        this.estadoOperativo = estadoOperativo;
        this.direccion = direccion;
        this.latitudA = latitudA;
        this.longitudA = longitudA;
    }

    public String getIdContenedor() {
        return idContenedor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getEstadoOperativo() {
        return estadoOperativo;
    }

    public String getDireccion() {
        return direccion;
    }

    public Double getLatitudA() {
        return latitudA;
    }

    public Double getLongitudA() {
        return longitudA;
    }
    
    
}
