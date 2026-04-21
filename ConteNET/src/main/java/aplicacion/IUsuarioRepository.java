/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

import dominio.Usuario;

/**
 *
 * @author lanch
 */
public interface IUsuarioRepository {
    void guardar(Usuario usuario);
    Usuario encontrarPorUsuario(String usuario);   
}
