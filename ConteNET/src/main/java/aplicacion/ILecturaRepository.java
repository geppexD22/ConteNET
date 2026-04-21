/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

import dominio.LecturaContenedor;
import java.util.List;

/**
 *
 * @author lanch
 */
public interface ILecturaRepository {
    void guardar(LecturaContenedor lectura);
    List<LecturaContenedor> encontrarTodos(String idContenedor);
    LecturaContenedor encontrarUltima(String idContenedor);
}
