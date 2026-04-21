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
public class UsuarioService {
    private final IUsuarioRepository usuarioRepo;

    public UsuarioService(IUsuarioRepository usuarioRepo) {
        this.usuarioRepo = usuarioRepo;
    }
   
    public Usuario login(String user, String password) {
        Usuario u = usuarioRepo.encontrarPorUsuario(user);
        if (u != null && u.getHashContrasena().equals(password) && u.getActivo()) {
            return u;
        }
        return null;
    }
}
