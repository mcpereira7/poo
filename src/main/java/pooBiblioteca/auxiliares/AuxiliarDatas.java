/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pooBiblioteca.auxiliares;

import java.sql.Date;
import java.util.Calendar;

/**
 *
 * @author Marcelo Pereira <macope727@gmail.com>
 */
public class AuxiliarDatas {
    
    public Date getDataPrevisaoEntrega(Date dtEmp){
        Calendar c = Calendar.getInstance();
        Date dataPrevisao;
        c.setTime(dtEmp);
        c.add(Calendar.DATE, +15);
        return dataPrevisao = (Date) c.getTime();
    }
    
    public int qtdDiasAtraso(Date dataPrevisao, Date dataEntrega){
        Calendar a = Calendar.getInstance();
        a.setTime(dataPrevisao);
        Calendar b = Calendar.getInstance();
        b.setTime(dataEntrega);
        b.add(Calendar.DATE, - a.get(Calendar.DAY_OF_MONTH));
        return b.get(Calendar.DAY_OF_MONTH);
    }
    
}
