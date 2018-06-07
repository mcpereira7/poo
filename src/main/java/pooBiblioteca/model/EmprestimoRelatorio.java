/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pooBiblioteca.model;

import java.util.Date;

/**
 *
 * @author Marcelo Pereira <macope727@gmail.com>
 */
public class EmprestimoRelatorio extends Emprestimo {

    private String cliente;

    public EmprestimoRelatorio() {
    }

    public EmprestimoRelatorio(String cliente, Date dtEmp, Date dtDev, boolean devolvido, int diasAtraso, double valorMulta) {
        super(dtEmp, dtDev, devolvido, diasAtraso, valorMulta, dtDev);
        this.cliente = cliente;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
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
    public Date getDtPrev() {
        return dtPrev;
    }

    @Override
    public void setDtPrev(Date dtPrev) {
        this.dtPrev = dtPrev;
    }

}
