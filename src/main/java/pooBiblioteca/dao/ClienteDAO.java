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
import java.util.ArrayList;
import java.util.List;
import pooBiblioteca.connection.ConnectionFactory;
import pooBiblioteca.model.Cliente;

/**
 *
 * @author Marcelo Pereira <macope727@gmail.com>
 */
public class ClienteDAO {

    private static Connection cn = null;

    public static void cadastrar(Cliente cli) throws SQLException, Exception {
        PreparedStatement stmt = null;
        cn = ConnectionFactory.getConnection();

        String sql = "INSERT INTO Cliente (Nome,CPF,Email,Telefone, Endereco) "
                + "VALUES (?,?,?,?,?)";
        
        try {
            stmt = cn.prepareStatement(sql);
            stmt.setString(1, cli.getNome());
            stmt.setString(2, cli.getCpf());
            stmt.setString(3, cli.getEmail());
            stmt.setString(4, cli.getTelefone());
            stmt.setString(5, cli.getEndereco());
            stmt.execute();
            
        } finally {
            ConnectionFactory.closeConnection(cn, stmt);
        }
    }
    
    public static void atualizar(Cliente cli) throws SQLException, Exception{
        PreparedStatement stmt = null;
        cn = ConnectionFactory.getConnection();
        
        String sql = "UPDATE Cliente SET id = ?,Nome = ?,CPF = ?,Email = ?,Telefone = ?, Endereco = ?"
                + "WHERE id = ?";
        
        try {
            stmt = cn.prepareStatement(sql);
            stmt.setInt(1, cli.getId());
            stmt.setString(2, cli.getNome());
            stmt.setString(3, cli.getCpf());
            stmt.setString(4, cli.getEmail());
            stmt.setString(5, cli.getTelefone());
            stmt.setString(6, cli.getEndereco());
            stmt.setInt(7, cli.getId());
            stmt.execute();
            
        } finally {
            ConnectionFactory.closeConnection(cn, stmt);
        }
    }
    
    public static void apagar(int id) throws SQLException, Exception{
        PreparedStatement stmt = null;
        cn = ConnectionFactory.getConnection();
       
        
        String sql = "DELETE FROM Cliente WHERE id = ?";
        
        try {
            stmt = cn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            
        } finally {
            ConnectionFactory.closeConnection(cn, stmt);
        }
    }
    
    public static List<Cliente> buscarByName(String nome) throws SQLException, Exception{
        PreparedStatement stmt = null;
        cn = ConnectionFactory.getConnection();
        ResultSet rs = null;
        List clientes = new ArrayList();
        Cliente cli = null;
        String sql = "SELECT * FROM Clientes WHERE nome like ?";
        
        try {
            stmt = cn.prepareStatement(sql);
            stmt.setString(1, "%" + nome + "%");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                cli = new Cliente();
                cli.setId(rs.getInt("id"));
                cli.setNome(rs.getString("Nome"));
                cli.setCpf(rs.getString("CPF"));
                cli.setEmail(rs.getString("Email"));
                cli.setTelefone(rs.getString("Telefone"));
                cli.setEndereco(rs.getString("endereco"));;
                clientes.add(cli);
            }
            
        } finally {
            ConnectionFactory.closeConnection(cn, stmt, rs);
        }
        return clientes;
    }
    public static Cliente buscarByCpf(String cpf) throws SQLException, Exception{
        PreparedStatement stmt = null;
        cn = ConnectionFactory.getConnection();
        ResultSet rs = null;
        Cliente cli = null;
        String sql = "SELECT * FROM Clientes WHERE CPF = ?";
        
        try {
            stmt = cn.prepareStatement(sql);
            stmt.setString(1, cpf);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                cli = new Cliente();
                cli.setId(rs.getInt("id"));
                cli.setNome(rs.getString("Nome"));
                cli.setCpf(rs.getString("CPF"));
                cli.setEmail(rs.getString("Email"));
                cli.setTelefone(rs.getString("Telefone"));
                cli.setEndereco(rs.getString("endereco"));;
                
            }
            
        } finally {
            ConnectionFactory.closeConnection(cn, stmt, rs);
        }
        return cli;
    }
}
