/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pooBiblioteca.model;

/**
 *
 * @author Marcelo Pereira <macope727@gmail.com>
 */
public class LivroAcervo extends Livro{
    
    private String subTitulo;
    private String autor;
    private String editora;
    private String idioma;
    private String resenha;
    private String dataPub;

    public LivroAcervo() {
    }

    public LivroAcervo(String autor, String editora, String idioma, String resenha, String dataPub, String subTitulo) {
        this.autor = autor;
        this.editora = editora;
        this.idioma = idioma;
        this.resenha = resenha;
        this.dataPub = dataPub;
        this.subTitulo = subTitulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getResenha() {
        return resenha;
    }

    public void setResenha(String resenha) {
        this.resenha = resenha;
    }

    public String getdataPub() {
        return dataPub;
    }

    public void setdataPub(String dataPub) {
        this.dataPub = dataPub;
    }

    public String getSubTitulo() {
        return subTitulo;
    }

    public void setSubTitulo(String subTitulo) {
        this.subTitulo = subTitulo;
    }

    @Override
    public String getIsbn() {
        return isbn;
    }

    @Override
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String getTitulo() {
        return titulo;
    }

    @Override
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String getCategoria() {
        return categoria;
    }

    @Override
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }
    
    
    
}
