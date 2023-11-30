package dao;

import model.Livro;

public interface LivroDAO {
    void cadastrarLivro(Livro livro);
    void listarLivros();
}