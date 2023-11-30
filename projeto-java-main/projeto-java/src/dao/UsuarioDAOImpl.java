package dao;

import model.Usuario;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOImpl implements UsuarioDAO {
    private List<Usuario> usuarios = new ArrayList<>();

    @Override
    public void cadastrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
     
        System.out.println("Usuário cadastrado com sucesso!");
    }

    @Override
    public void listarUsuarios() {
        for (Usuario usuario : usuarios) {
            System.out.println(usuario.getNome() + " - " + usuario.getCpf());
        }
    }
}
