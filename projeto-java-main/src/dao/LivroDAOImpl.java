package dao;

import model.Livro;
import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LivroDAOImpl implements LivroDAO {

    @Override
    public void cadastrarLivro(Livro livro) {
        Connection conexao = Conexao.GerarConexao();
        if (conexao != null) {
            try {
                String sql = "INSERT INTO Livro (titulo, autor, ano_publicacao, genero, quantidade_disponivel) VALUES (?, ?, ?, ?, ?)";
                try (PreparedStatement statement = conexao.prepareStatement(sql)) {
                    statement.setString(1, livro.getTitulo());
                    statement.setString(2, livro.getAutor());
                    statement.setInt(3, livro.getAnoPublicacao());
                    statement.setString(4, livro.getGenero());
                    statement.setInt(5, livro.getQuantidadeDisponivel());

                    statement.executeUpdate();
                    System.out.println("Livro cadastrado com sucesso!");
                }
            } catch (SQLException e) {
                System.out.println("Erro ao cadastrar o livro: " + e.getMessage());
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
    public void listarLivros() {
        Connection conexao = Conexao.GerarConexao();

        if (conexao != null) {
            try {
                String sql = "SELECT titulo, autor, ano_publicacao, genero, quantidade_disponivel FROM Livro";
                try (PreparedStatement statement = conexao.prepareStatement(sql);
                     ResultSet resultSet = statement.executeQuery()) {

                    System.out.println("Lista de Livros:");
                    while (resultSet.next()) {
                        String titulo = resultSet.getString("titulo");
                        String autor = resultSet.getString("autor");
                        int anoPublicacao = resultSet.getInt("ano_publicacao");
                        String genero = resultSet.getString("genero");
                        int quantidadeDisponivel = resultSet.getInt("quantidade_disponivel");

                        System.out.println(titulo + " - " + autor + " | " +  anoPublicacao + " (" + genero + ") | " + quantidadeDisponivel + " unidades disponívels");
                    }
                }
            } catch (SQLException e) {
                System.out.println("Erro ao listar os livros: " + e.getMessage());
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
