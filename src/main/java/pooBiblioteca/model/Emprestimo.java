/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pooBiblioteca.model;

import java.util.Calendar;

/**
 *
 * @author vinicius.presoto
 */
public class Emprestimo extends Livro{
    
    private Calendar dtEmp;
    private Calendar dtDev;
    private boolean dvAtraso; // Se devolução occoreu após a data prevista
    private int diasAtraso;
    private double valorMulta;

    public Emprestimo() {
    }

    public Emprestimo(Calendar dtEmp, Calendar dtDev, boolean dvAtraso, int diasAtraso, double valorMulta) {
        this.dtEmp = dtEmp;
        this.dtDev = dtDev;
        this.dvAtraso = dvAtraso;
        this.diasAtraso = diasAtraso;
        this.valorMulta = valorMulta;
    }

    public Calendar getDtEmp() {
        return dtEmp;
    }

    public void setDtEmp(Calendar dtEmp) {
        this.dtEmp = dtEmp;
    }

    public Calendar getDtDev() {
        return dtDev;
    }

    public void setDtDev(Calendar dtDev) {
        this.dtDev = dtDev;
    }

    public boolean isDvAtraso() {
        return dvAtraso;
    }

    public void setDvAtraso(boolean dvAtraso) {
        this.dvAtraso = dvAtraso;
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
        if(isDvAtraso()){
        this.valorMulta = this.diasAtraso * valorMulta;
        }
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
