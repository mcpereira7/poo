/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pooBiblioteca.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pooBiblioteca.auxiliares.AuxiliarDatas;
import pooBiblioteca.connection.ConnectionFactory;
import pooBiblioteca.model.LivroAcervo;
import pooBiblioteca.model.Emprestimo;

/**
 *
 * @author Marcelo Pereira <macope727@gmail.com>
 */
public class EmprestimoDAO {

    private static Connection cn = null;

    public static void registrar(Emprestimo livro, String cpf) throws SQLException, Exception {
        PreparedStatement stmt = null;
        cn = ConnectionFactory.getConnection();
        AuxiliarDatas aux = new AuxiliarDatas();
        Date dataPrevisao = aux.getDataPrevisaoEntrega(livro.getDtEmp());

        String sql = "INSERT INTO ItemLivro (ISBN,dtEmprest,dtPrevista,ValorMulta, DiasAtraso, Cliente) "
                + "VALUES (?,?,?,?,?,?)";
        
        try {
            stmt = cn.prepareStatement(sql);
            stmt.setString(1, livro.getIsbn());
            stmt.setDate(2,   livro.getDtEmp());
            stmt.setDate(3, dataPrevisao);
            stmt.setDouble(4, livro.getValorMulta());
            stmt.setInt(5, 0);
            stmt.setString(6, cpf);
            stmt.execute();
            
        } finally {
            ConnectionFactory.closeConnection(cn, stmt);
        }
    }
    
    public static void atualizar(Emprestimo livro) throws SQLException, Exception{
        PreparedStatement stmt = null;
        cn = ConnectionFactory.getConnection();
        
        String sql = "UPDATE Livro SET dtDevol = ?,ValosMulta = ?,DiasAtraso = ?,Devolvido = ?"
                + "WHERE ISBN = ?";
        
        try {
            stmt = cn.prepareStatement(sql);
            stmt.setDate(1, livro.getDtDev());
            stmt.setDouble(2, livro.getValorMulta());
            stmt.setInt(3, livro.getDiasAtraso());
            stmt.setBoolean(4, livro.isDevolvido());
            stmt.setString(5, livro.getIsbn());
            stmt.execute();
            
        } finally {
            ConnectionFactory.closeConnection(cn, stmt);
        }
    }
    
    public static List<LivroAcervo> buscar(String nome) throws SQLException, Exception{
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List livros = new ArrayList();
        LivroAcervo livro = null;
        String sql = "SELECT * FROM Livro WHERE Nome like ?;";
        cn = ConnectionFactory.getConnection();
        
        try {
            stmt = cn.prepareStatement(sql);
            stmt.setString(1, "%" + nome + "%");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                livro = new LivroAcervo();
                livro.setIsbn(rs.getString("ISBN"));
                livro.setTitulo(rs.getString("Nome"));
                livro.setCategoria(rs.getString("Categoria"));
                livro.setResenha(rs.getString("Resenha"));
                livro.setEditora(rs.getString("Editora"));
                livro.setdataPub(rs.getString("AnoPub"));
                livro.setIdioma(rs.getString("Idioma"));
                livro.setAutor(rs.getString("Autor"));
                livro.setNumPaginas(rs.getInt("NumPaginas"));
                livro.setQtd(rs.getInt("qtd"));
                livros.add(livro);
            }
            
        } finally {
            ConnectionFactory.closeConnection(cn, stmt, rs);
        }
        return livros;
    }
    
    public static List<LivroAcervo> buscarTop10() throws SQLException, Exception{
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List livros = new ArrayList();
        LivroAcervo livro = null;
        String sql = "SELECT * FROM Livro ORDER BY dtCadastro DESC LIMIT 10;";
        cn = ConnectionFactory.getConnection();
        
        try {
            stmt = cn.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                livro = new LivroAcervo();
                livro.setIsbn(rs.getString("ISBN"));
                livro.setTitulo(rs.getString("Nome"));
                livro.setCategoria(rs.getString("Categoria"));
                livro.setResenha(rs.getString("Resenha"));
                livro.setEditora(rs.getString("Editora"));
                livro.setdataPub(rs.getString("AnoPub"));
                livro.setIdioma(rs.getString("Idioma"));
                livro.setAutor(rs.getString("Autor"));
                livro.setNumPaginas(rs.getInt("NumPaginas"));
                livro.setQtd(rs.getInt("qtd"));
                livros.add(livro);
            }
            
        } finally {
            ConnectionFactory.closeConnection(cn, stmt, rs);
        }
        return livros;
    }
}
