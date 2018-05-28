/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pooBiblioteca.controllers;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pooBiblioteca.dao.LivroDAO;
import pooBiblioteca.model.LivroAcervo;

/**
 *
 * @author Marcelo Pereira <macope727@gmail.com>
 */
public class ServicoLivro {
    
    public static void cadastrar(LivroAcervo livro) throws SQLException, Exception{
        try {
            LivroDAO.cadastrar(livro);
        } catch (SQLException ex) {
            Logger.getLogger(ServicoLivro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
