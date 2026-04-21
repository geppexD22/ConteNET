/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

import dominio.Contenedor;
import dominio.LecturaContenedor;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author lanch
 */
public class ContenedorService {
    
    private final IContenedorRepository contenedorRepo;
    private final ILecturaRepository lecturaRepo;

    public ContenedorService(IContenedorRepository contenedorRepo, ILecturaRepository lecturaRepo) {
        this.contenedorRepo = contenedorRepo;
        this.lecturaRepo = lecturaRepo;
    }
    
    public void registrarNuevaLectura(LecturaContenedor nueva){
        lecturaRepo.guardar(nueva);
    }
    
    public List<Contenedor> obtenerRutaOptima() {
        return contenedorRepo.encontrarTodos().stream()
            .filter(c -> {
                LecturaContenedor ultima = lecturaRepo.encontrarUltima(c.getIdContenedor());
                return ultima != null && ultima.esNivelCritico(); 
            })
            .collect(Collectors.toList());
    }
}
