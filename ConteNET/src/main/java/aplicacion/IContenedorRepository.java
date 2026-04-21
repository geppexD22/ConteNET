/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

import dominio.Contenedor;
import java.util.List;

/**
 *
 * @author lanch
 */
public interface IContenedorRepository {
    void guardar(Contenedor contenedor);
    List<Contenedor> encontrarTodos();
    Contenedor encontrarPorId(String idContenedor);
}
