import dao.LivroDAO;
import dao.LivroDAOImpl;
import dao.UsuarioDAO;
import dao.UsuarioDAOImpl;
import model.Livro;
import model.Usuario;

import java.util.Scanner;

public class BibliotecaMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LivroDAO livroDAO = new LivroDAOImpl();
        UsuarioDAO usuarioDAO = new UsuarioDAOImpl();

        while (true) {
            System.out.println("1. Cadastrar Livro");
            System.out.println("2. Listar Livros");
            System.out.println("3. Cadastrar Usuário");
            System.out.println("4. Listar Usuários");
            System.out.println("0. Sair");

            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarLivro(scanner, livroDAO);
                    break;
                case 2:
                    livroDAO.listarLivros();
                    break;
                case 3:
                    cadastrarUsuario(scanner, usuarioDAO);
                    break;
                case 4:
                    usuarioDAO.listarUsuarios();
                    break;
                case 0:
                    System.out.println("Saindo do sistema. Até mais!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void cadastrarLivro(Scanner scanner, LivroDAO livroDAO) {
        Scanner leitura = new Scanner(System.in);
        System.out.print("Digite o título do livro: ");
        String titulo = leitura.nextLine();

        System.out.print("Digite o autor do livro: ");
        String autor = leitura.nextLine();

        int anoPublicacao;
        while (true) {
            try {
                System.out.print("Digite o ano de publicação do livro: ");
                anoPublicacao = Integer.parseInt(leitura.nextLine());
                break;  // Saia do loop se a conversão for bem-sucedida
            } catch (NumberFormatException e) {
                System.out.println("Por favor, digite um número válido para o ano de publicação.");
            }
        }

        System.out.print("Digite o gênero do livro: ");
        String genero = leitura.nextLine();

        System.out.print("Digite a quantidade disponível do livro: ");
        int quantidadeDisponivel;
        while (true) {
            try {
                quantidadeDisponivel = Integer.parseInt(leitura.nextLine());
                break;  // Saia do loop se a conversão for bem-sucedida
            } catch (NumberFormatException e) {
                System.out.println("Por favor, digite um número válido para a quantidade disponível.");
            }
        }

        Livro livro = new Livro(titulo, autor, anoPublicacao, genero, quantidadeDisponivel);
        livroDAO.cadastrarLivro(livro);
    }


    private static void cadastrarUsuario(Scanner scanner, UsuarioDAO usuarioDAO) {
        Scanner leitura = new Scanner(System.in);
        System.out.print("Digite o nome do usuário: ");
        String nome = leitura.nextLine();
        System.out.print("Digite o CPF do usuário: ");
        String cpf = leitura.nextLine();
        System.out.print("Digite o email do usuário: ");
        String email = leitura.nextLine();
        System.out.print("Digite o número de telefone do usuário: ");
        String telefone = leitura.nextLine();

        Usuario usuario = new Usuario(nome, cpf, email, telefone);
        usuarioDAO.cadastrarUsuario(usuario);
    }
}
