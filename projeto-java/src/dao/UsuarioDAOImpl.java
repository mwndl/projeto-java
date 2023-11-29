package dao;

import model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOImpl implements UsuarioDAO {

    @Override
    public void cadastrarUsuario(Usuario usuario) {
        try (Connection connection = dao.ConnectionFactory.getConnection()) {
            String sql = "INSERT INTO usuarios (nome, cpf, email, telefone) VALUES (?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, usuario.getNome());
                preparedStatement.setString(2, usuario.getCpf());
                preparedStatement.setString(3, usuario.getEmail());
                preparedStatement.setString(4, usuario.getTelefone());

                preparedStatement.executeUpdate();
                System.out.println("Usuário cadastrado com sucesso!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void listarUsuarios() {
        try (Connection connection = dao.ConnectionFactory.getConnection()) {
            String sql = "SELECT nome, cpf FROM usuarios";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    String nome = resultSet.getString("nome");
                    String cpf = resultSet.getString("cpf");
                    System.out.println(nome + " - " + cpf);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
