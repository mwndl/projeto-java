package dao;

import model.Usuario;

public interface UsuarioDAO {
    void cadastrarUsuario(Usuario usuario);
    void listarUsuarios();
}
