package Biblioteca;

import java.util.Scanner;

public class NewMain {

    public static void main(String[] args) {
        // Carregar livros a partir de um arquivo JSON
        Livro[] livros = Livro.carregaLivros("livros.json");
        
        // Instanciar a classe Operacoes
        Operacoes operacoes = new Operacoes();
        Scanner teclado = new Scanner(System.in);
        String opcao;

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Listar livros");
            System.out.println("2 - Listar livros por ordem de Título");
            System.out.println("3 - Listar livros por ordem de Autor");
            System.out.println("4 - Buscar livros");
            System.out.println("0 - Sair");

            opcao = teclado.nextLine();

            switch (opcao) {
                case "1":
                    listarLivros(livros);
                    break;
                case "2":
                    livros = operacoes.listaOrdenado(livros);
                    listarLivros(livros);
                    break;
                case "3":
                    livros = operacoes.listaOrdenadoAutor(livros);
                    listarLivros(livros);
                    break;
                case "4":
                    operacoes.buscarLivros(livros);
                    break;
                case "0":
                    System.out.println("FIM");
                    System.exit(0);
                default:
                    System.out.println("Escolha outra opção");
            }
        }
    }

    // Método para listar livros
    private static void listarLivros(Livro[] livros) {
        if (livros != null && livros.length > 0) {
            System.out.println("Listando os Livros");
            for (Livro livro : livros) {
                System.out.println("Título: " + livro.getTitulo());
                System.out.println("Autor: " + livro.getAutor());
                System.out.println("Gênero: " + livro.getGenero());
                System.out.println("Exemplares: " + livro.getExemplares());
                System.out.println("----------------");
            }
        } else {
            System.out.println("Não há livros carregados.");
        }
    }
}
