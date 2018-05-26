/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pooBiblioteca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        
        String sql = "UPDATE Bibliotecario SET id = ?, Nome = ?, Email = ?, Login = ?, Senha = ?, Ativo = ?"
                + "WHERE id = ?";
        
        try {
            stmt = cn.prepareStatement(sql);
            stmt.setInt(1, user.getId());
            stmt.setString(2, user.getNome());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getLogin());
            stmt.setString(5, user.getSenha());
            stmt.setBoolean(6, user.isAtivo());
            stmt.setInt(7, user.getId());
            stmt.execute();
            
        } finally {
            ConnectionFactory.closeConnection(cn, stmt);
        }
    }
    
    public static void apagarBibliotecario(int id) throws SQLException, Exception{
        PreparedStatement stmt = null;
        cn = ConnectionFactory.getConnection();
       
        
        String sql = "UPDATE Bibliotecario SET Ativo = ? WHERE id = ?";
        
        try {
            stmt = cn.prepareStatement(sql);
            stmt.setBoolean(1, false);
            stmt.setInt(2, id);
            stmt.execute();
            
        } finally {
            ConnectionFactory.closeConnection(cn, stmt);
        }
    }
    
    public static Bibliotecario buscarBibliotecario(int id) throws SQLException, Exception{
        PreparedStatement stmt = null;
        cn = ConnectionFactory.getConnection();
        ResultSet rs = null;
        Bibliotecario user = null;
        String sql = "SELECT * FROM Bibliotecario WHERE id = ?";
        
        try {
            stmt = cn.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                user = new Bibliotecario();
                user.setId(rs.getInt("id"));
                user.setNome(rs.getString("Nome"));
                user.setEmail(rs.getString("Email"));
                user.setLogin(rs.getString("Login"));
                user.setSenha(rs.getString("Senha"));
                user.setAtivo(rs.getBoolean("Ativo"));
            }
            
        } finally {
            ConnectionFactory.closeConnection(cn, stmt, rs);
        }
        return user;
    }
}
