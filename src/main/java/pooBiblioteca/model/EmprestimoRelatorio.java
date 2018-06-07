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
        super(dtEmp, dtDev, dtDev, devolvido, diasAtraso, valorMulta);
        this.cliente = cliente;
    }

   

}
