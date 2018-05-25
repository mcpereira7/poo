/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pooBiblioteca.model;

/**
 *
 * @author vinicius.presoto
 */
public class Livro {

    private String isbn;
    private String titulo;
    private int anoPub;
    private String categoria;
    private String resenha;
    private String ditora;
    private String idioma;
    private int idAutor;

    public Livro() {
    }

    public Livro(String isbn, String titulo, int anoPub, String categoria, String resenha, String ditora, String idioma, int idAutor) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.anoPub = anoPub;
        this.categoria = categoria;
        this.resenha = resenha;
        this.ditora = ditora;
        this.idioma = idioma;
        this.idAutor = idAutor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnoPub() {
        return anoPub;
    }

    public void setAnoPub(int anoPub) {
        this.anoPub = anoPub;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getResenha() {
        return resenha;
    }

    public void setResenha(String resenha) {
        this.resenha = resenha;
    }

    public String getDitora() {
        return ditora;
    }

    public void setDitora(String ditora) {
        this.ditora = ditora;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

   
}
