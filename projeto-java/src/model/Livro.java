package model;

public class Livro {
    private String titulo;
    private String autor;
    private int anoPublicacao;
    private String genero;
    private int quantidadeDisponivel;

    public Livro(String titulo, String autor, int anoPublicacao, String genero, int quantidadeDisponivel) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.genero = genero;
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    // Getters e Setters
    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public String getGenero() {
        return genero;
    }

    public int getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public static interface UsuarioDAO {
        void cadastrarUsuario(Usuario usuario);
        void listarUsuarios();
    }
}
