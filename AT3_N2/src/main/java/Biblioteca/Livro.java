package Biblioteca;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Livro {
    private String titulo;
    private String autor;
    private String genero;
    private int exemplares;

    // Construtores
    public Livro() {
        this.titulo = "";
        this.autor = "";
        this.genero = "";
        this.exemplares = 0;
    }

    public Livro(String titulo, String autor, String genero, int exemplares) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.exemplares = exemplares;
    }

    // Getters e Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getExemplares() {
        return exemplares;
    }

    public void setExemplares(int exemplares) {
        this.exemplares = exemplares;
    }

    // Método para carregar livros de um arquivo JSON
    public static Livro[] carregaLivros(String fileName) {
        List<Livro> livrosList = new ArrayList<>();
        try {
            JsonParser parser = new JsonParser();
            JsonObject jsonObject = parser.parse(new FileReader(fileName)).getAsJsonObject();
            JsonArray livros = jsonObject.getAsJsonArray("livros");

            for (int i = 0; i < livros.size(); i++) {
                JsonObject livroObj = livros.get(i).getAsJsonObject();
                String titulo = livroObj.get("titulo").getAsString();
                String autor = livroObj.get("autor").getAsString();
                String genero = livroObj.get("genero").getAsString();
                int exemplares = livroObj.get("exemplares").getAsInt();
                Livro livro = new Livro(titulo, autor, genero, exemplares);
                livrosList.add(livro);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return livrosList.toArray(new Livro[0]);
    }
}
