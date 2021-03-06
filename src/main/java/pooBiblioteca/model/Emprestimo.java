/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pooBiblioteca.model;

import java.util.Date;

/**
 *
 * @author vinicius.presoto
 */
public class Emprestimo extends Livro{
    
    protected Date dtEmp;
    protected Date dtDev;
    protected Date dtPrev;
    protected boolean devolvido; 
    protected int diasAtraso;
    protected double valorMulta;
    

    public Emprestimo() {
    }

    public Emprestimo(Date dtEmp, Date dtDev, Date dtPrev, boolean devolvido, int diasAtraso, double valorMulta) {
        this.dtEmp = dtEmp;
        this.dtDev = dtDev;
        this.dtPrev = dtPrev;
        this.devolvido = devolvido;
        this.diasAtraso = diasAtraso;
        this.valorMulta = valorMulta;
    }

    public Date getDtEmp() {
        return dtEmp;
    }

    public void setDtEmp(Date dtEmp) {
        this.dtEmp = dtEmp;
    }

    public Date getDtDev() {
        return dtDev;
    }

    public void setDtDev(Date dtDev) {
        this.dtDev = dtDev;
    }

    public boolean isDevolvido() {
        return devolvido;
    }

    public void setDevolvido(boolean devolvido) {
        this.devolvido = devolvido;
    }

    public int getDiasAtraso() {
        return diasAtraso;
    }

    public void setDiasAtraso(int diasAtraso) {
        this.diasAtraso = diasAtraso;
    }

    public double getValorMulta() {
        return valorMulta;
    }

    public void setValorMulta(double valorMulta) {
        this.valorMulta = this.diasAtraso * valorMulta;
    }

    public Date getDtPrev() {
        return dtPrev;
    }

    public void setDtPrev(Date dtPrev) {
        this.dtPrev = dtPrev;
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

    @Override
    public int getNumPaginas() {
        return numPaginas;
    }

    @Override
    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }
    
    
    
}
