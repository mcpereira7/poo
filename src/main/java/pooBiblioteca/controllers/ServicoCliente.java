/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pooBiblioteca.controllers;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pooBiblioteca.dao.ClienteDAO;
import pooBiblioteca.model.Cliente;

/**
 *
 * @author Marcelo Pereira <macope727@gmail.com>
 */
public class ServicoCliente {
    
    public static void cadastrar(Cliente cli) throws SQLException, Exception{
        try {
            ClienteDAO.cadastrar(cli);
        } catch (SQLException ex) {
            Logger.getLogger(ServicoLivro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
