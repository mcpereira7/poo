/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pooBiblioteca.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pooBiblioteca.dao.EmprestimoDAO;
import pooBiblioteca.dao.LivroDAO;
import pooBiblioteca.model.Emprestimo;
import pooBiblioteca.model.EmprestimoRelatorio;
import pooBiblioteca.model.LivroAcervo;

/**
 *
 * @author Marcelo Pereira <macope727@gmail.com>
 */
public class ServicoEmprestimo {
    
    public static void cadastrar(Emprestimo emp, String cpf) throws SQLException, Exception{
        try {
            EmprestimoDAO.registrar(emp, cpf);
        } catch (SQLException ex) {
            Logger.getLogger(ServicoEmprestimo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static List<EmprestimoRelatorio> consultar(Date ini, Date fim) throws SQLException, Exception{
        List<EmprestimoRelatorio> listaEmp = new ArrayList<>();
        java.sql.Date dti = new java.sql.Date (ini.getTime());
        java.sql.Date dtf = new java.sql.Date (fim.getTime());
        
        try {
            listaEmp = EmprestimoDAO.buscar(dti, dtf);
        } catch (Exception e) {
            
        }
        
        return listaEmp;
    }
    
    public static LivroAcervo consultarByIsbn(String isbn) throws SQLException, Exception{
        LivroAcervo livro = new LivroAcervo();
        
        try {
            livro = LivroDAO.buscarByIsbn(isbn);
        } catch (Exception e) {
            
        }
        
        return livro;
    }
    
     public static List<LivroAcervo> consultarTop10() throws SQLException, Exception{
        List<LivroAcervo> listaLivro = new ArrayList<>();
        
        try {
            listaLivro = LivroDAO.buscarTop10();
        } catch (Exception e) {
            
        }
        
        return listaLivro;
    }
    
}
