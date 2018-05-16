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
public class Emprestimo {
    
    private int id;
    private Calendar data;
    private Calendar dataDev;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public Calendar getDataDev() {
        return dataDev;
    }

    public void setDataDev(Calendar dataDev) {
        this.dataDev = dataDev;
    }
    
    
    
}
