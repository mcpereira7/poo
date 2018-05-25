/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pooBiblioteca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import pooBiblioteca.connection.ConnectionFactory;
import pooBiblioteca.model.Bibliotecario;

/**
 *
 * @author Marcelo Pereira <macope727@gmail.com>
 */
public class BibliotecarioDAO {

    private static Connection cn = null;

    public static void cadBibliotecario(Bibliotecario user) throws SQLException, Exception {
        PreparedStatement stmt = null;
        cn = ConnectionFactory.getConnection();

        String sql = "INSERT INTO Bibliotecario (Nome,Email,Login,senha) "
                + "VALUES (?,?,?,?)";
        
        try {
            stmt = cn.prepareStatement(sql);
            stmt.setString(1, user.getNome());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getLogin());
            stmt.setString(4, user.getSenha());
            stmt.execute();
            
        } finally {
            ConnectionFactory.closeConnection(cn, stmt);
        }
    }
    
    public static void atualizarBibliotecario(Bibliotecario user) throws SQLException, Exception{
        PreparedStatement stmt = null;
        cn = ConnectionFactory.getConnection();
        
        String sql = "UPDATE Bibliotecario SET id = ?, Nome = ?, Email = ?, Login = ?, Senha = ?"
                + "WHERE id = ?";
        
        try {
            stmt = cn.prepareStatement(sql);
            stmt.setInt(1, user.getId());
            stmt.setString(2, user.getNome());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getLogin());
            stmt.setString(5, user.getSenha());
            stmt.setInt(6, user.getId());
            stmt.execute();
            
        } finally {
            ConnectionFactory.closeConnection(cn, stmt);
        }
    }
    
    public static void apagarBibliotecario(int id) throws SQLException, Exception{
        PreparedStatement stmt = null;
        cn = ConnectionFactory.getConnection();
        
        String sql = "";
        
        try {
            
        } finally {
        }
    }
    
    public static Bibliotecario select(int id) throws SQLException, Exception{
        PreparedStatement stmt = null;
        cn = ConnectionFactory.getConnection();
        
        String sql = "";
        
        try {
            
        } finally {
        }
        return null;
    }
}
