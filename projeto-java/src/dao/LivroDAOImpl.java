package dao;

import model.Livro;
import java.util.ArrayList;
import java.util.List;

public class LivroDAOImpl implements LivroDAO {
    private List<Livro> livros = new ArrayList<>();

    @Override
    public void cadastrarLivro(Livro livro) {
        livros.add(livro);
        System.out.println("Livro cadastrado com sucesso!");
    }

    @Override
    public void listarLivros() {
        for (Livro livro : livros) {
            System.out.println(livro.getTitulo() + " - " + livro.getAutor());
        }
    }
}
