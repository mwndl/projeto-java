package dao;

import util.Conexao;
import model.Usuario;
import java.sql.*;

public class UsuarioDAOImpl implements UsuarioDAO {

    @Override
    public void cadastrarUsuario(Usuario usuario) {
        Connection conexao = Conexao.GerarConexao();

        if (conexao != null) {

            try {
                String sql = "INSERT INTO usuarios (nome, cpf, email, telefone) VALUES (?, ?, ?, ?)";
                try (PreparedStatement statement = conexao.prepareStatement(sql)) {
                    statement.setString(1, usuario.getNome());
                    statement.setString(2, usuario.getCpf());
                    statement.setString(3, usuario.getEmail());
                    statement.setString(4, usuario.getTelefone());

                    statement.executeUpdate();
                    System.out.println("Usuário cadastrado com sucesso!");
                }
            } catch (SQLException e) {
                System.out.println("Erro ao cadastrar o usuário: " + e.getMessage());
            } finally {
                try {
                    conexao.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("Sem conexão com o banco de dados.");
        }
    }

    @Override
    public void listarUsuarios() {
        Connection conexao = Conexao.GerarConexao();

        if (conexao != null) {
            try {
                String sql = "SELECT nome, cpf, email, telefone FROM usuarios";
                try (PreparedStatement statement = conexao.prepareStatement(sql);
                     ResultSet resultSet = statement.executeQuery()) {

                    System.out.println("Lista de Usuários:");
                    while (resultSet.next()) {
                        String nome = resultSet.getString("nome");
                        String cpf = resultSet.getString("cpf");
                        String email = resultSet.getString("email");
                        String telefone = resultSet.getString("telefone");

                        System.out.println(nome + " (" + cpf + ")" + " | " + email + " - " + telefone);
                    }
                }
            } catch (SQLException e) {
                System.out.println("Erro ao listar os usuários: " + e.getMessage());
            } finally {
                try {
                    conexao.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("Sem conexão com o banco de dados.");
        }
    }
}
