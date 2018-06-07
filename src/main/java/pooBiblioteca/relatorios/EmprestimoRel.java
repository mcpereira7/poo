/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pooBiblioteca.relatorios;

import java.util.Date;
import pooBiblioteca.model.Emprestimo;

/**
 *
 * @author Marcelo Pereira <macope727@gmail.com>
 */
public class EmprestimoRel extends Emprestimo{
    private String cliente;

    public EmprestimoRel() {
    }

    public EmprestimoRel(String cliente, Date dtEmp, Date dtDev, Date dtPrev, boolean devolvido, int diasAtraso, double valorMulta) {
        super(dtEmp, dtDev, dtPrev, devolvido, diasAtraso, valorMulta);
        this.cliente = cliente;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    @Override
    public Date getDtEmp() {
        return dtEmp;
    }

    @Override
    public void setDtEmp(Date dtEmp) {
        this.dtEmp = dtEmp;
    }

    @Override
    public Date getDtDev() {
        return dtDev;
    }

    @Override
    public void setDtDev(Date dtDev) {
        this.dtDev = dtDev;
    }

    @Override
    public Date getDtPrev() {
        return dtPrev;
    }

    @Override
    public void setDtPrev(Date dtPrev) {
        this.dtPrev = dtPrev;
    }

    @Override
    public boolean isDevolvido() {
        return devolvido;
    }

    @Override
    public void setDevolvido(boolean devolvido) {
        this.devolvido = devolvido;
    }

    @Override
    public int getDiasAtraso() {
        return diasAtraso;
    }

   
    @Override
    public void setDiasAtraso(int diasAtraso) {
        this.diasAtraso = diasAtraso;
    }

    @Override
    public double getValorMulta() {
        return valorMulta;
    }

    @Override
    public void setValorMulta(double valorMulta) {
        this.valorMulta = valorMulta;
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
    public int getQtd() {
        return qtd;
    }

    @Override
    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
    
    
}
