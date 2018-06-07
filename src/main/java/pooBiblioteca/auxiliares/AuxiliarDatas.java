/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pooBiblioteca.auxiliares;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Marcelo Pereira <macope727@gmail.com>
 */
public class AuxiliarDatas {
    
    public static Date getDataPrevisaoEntrega(Date dtEmp){
        Calendar c = Calendar.getInstance();
        Date dataPrevisao;
        c.setTime(dtEmp);
        c.add(Calendar.DATE, +15);
        return dataPrevisao = (Date) c.getTime();
    }
    
    public static int qtdDiasAtraso(Date dataPrevisao, Date dataEntrega){
        Calendar a = Calendar.getInstance();
        a.setTime(dataPrevisao);
        Calendar b = Calendar.getInstance();
        b.setTime(dataEntrega);
        b.add(Calendar.DATE, - a.get(Calendar.DAY_OF_MONTH));
        return b.get(Calendar.DAY_OF_MONTH);
    }
    
    public static java.util.Date ftmtData() {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date data = new java.util.Date(System.currentTimeMillis());
        String date = formato.format(data);
        try {
            return data = formato.parse(date);
        } catch (Exception e) {
        }
        return null;
    }
    
    public static java.util.Date ftmtDataRequest(String dt) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date data = null;
        try {
            return data = formato.parse(dt);
        } catch (Exception e) {
        }
        return null;
    }
    
}
