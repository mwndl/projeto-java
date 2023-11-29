package dao;

import model.Livro;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LivroDAOImpl implements LivroDAO {

    @Override
    public void cadastrarLivro(Livro livro) {
        try (Connection connection = dao.ConnectionFactory.getConnection()) {

            String sql = "INSERT INTO livros (titulo, autor, ano_publicacao, genero, quantidade_disponivel) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, livro.getTitulo());
                preparedStatement.setString(2, livro.getAutor());
                preparedStatement.setInt(3, livro.getAnoPublicacao());
                preparedStatement.setString(4, livro.getGenero());
                preparedStatement.setInt(5, livro.getQuantidadeDisponivel());

                preparedStatement.executeUpdate();
                System.out.println("Livro cadastrado com sucesso!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void listarLivros() {
        try (Connection connection = dao.ConnectionFactory.getConnection()) {
            String sql = "SELECT titulo, autor FROM livros";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    String titulo = resultSet.getString("titulo");
                    String autor = resultSet.getString("autor");
                    System.out.println(titulo + " - " + autor);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
