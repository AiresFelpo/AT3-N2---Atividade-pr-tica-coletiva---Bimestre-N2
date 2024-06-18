package Biblioteca;

import java.util.Scanner;

public class Operacoes {
    
    // Método para buscar livros por título ou autor
    public void buscarLivros(Livro[] livros) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite o termo (Autor ou título) desejado:");
        String nome = teclado.nextLine();

        boolean found = false;
        for (Livro livro : livros) {
            if (livro.getTitulo().toLowerCase().contains(nome.toLowerCase()) || 
                livro.getAutor().toLowerCase().contains(nome.toLowerCase())) {
                found = true;
                System.out.println("Título: " + livro.getTitulo());
                System.out.println("Autor: " + livro.getAutor());
                System.out.println("Gênero: " + livro.getGenero());
                System.out.println("Exemplares: " + livro.getExemplares());
                System.out.println("----------------");
            }
        }
        if (!found) {
            System.out.println("Nenhum livro encontrado com o termo: " + nome);
        }
    }

    // Métodos para ordenar livros por título e autor
    public Livro[] listaOrdenado(Livro[] livros) {
        Livro livroTemp;
        for (int i = 0; i < livros.length; i++) {
            for (int j = 0; j < livros.length - 1 - i; j++) {
                if (livros[j].getTitulo().compareToIgnoreCase(livros[j + 1].getTitulo()) > 0) {
                    livroTemp = livros[j];
                    livros[j] = livros[j + 1];
                    livros[j + 1] = livroTemp;
                }
            }
        }
        return livros;
    }

    public Livro[] listaOrdenadoAutor(Livro[] livros) {
        Livro livroTemp;
        for (int i = 0; i < livros.length; i++) {
            for (int j = 0; j < livros.length - 1 - i; j++) {
                if (livros[j].getAutor().compareToIgnoreCase(livros[j + 1].getAutor()) > 0) {
                    livroTemp = livros[j];
                    livros[j] = livros[j + 1];
                    livros[j + 1] = livroTemp;
                }
            }
        }
        return livros;
    }
}
