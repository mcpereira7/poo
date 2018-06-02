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
import pooBiblioteca.model.Livro;
import pooBiblioteca.model.LivroAcervo;

/**
 *
 * @author Marcelo Pereira <macope727@gmail.com>
 */
public class LivroDAO {

    private static Connection cn = null;

    public static void cadastrar(LivroAcervo livro) throws SQLException, Exception {
        PreparedStatement stmt = null;
        cn = ConnectionFactory.getConnection();

        String sql = "INSERT INTO Livro (ISBN,Nome,Categoria,Resenha,Editora, AnoPub, Idioma, Autor, NumPaginas) "
                + "VALUES (?,?,?,?,?,?,?,?,?)";
        
        try {
            stmt = cn.prepareStatement(sql);
            stmt.setString(1, livro.getIsbn());
            stmt.setString(2, livro.getTitulo());
            stmt.setString(3, livro.getCategoria());
            stmt.setString(4, livro.getResenha());
            stmt.setString(5, livro.getEditora());
            stmt.setString(6, livro.getdataPub());
            stmt.setString(7, livro.getIdioma());
            stmt.setString(8, livro.getAutor());
            stmt.setInt(9, livro.getNumPaginas());
            stmt.execute();
            
        } finally {
            ConnectionFactory.closeConnection(cn, stmt);
        }
    }
    
    public static void atualizar(LivroAcervo livro) throws SQLException, Exception{
        PreparedStatement stmt = null;
        cn = ConnectionFactory.getConnection();
        
        String sql = "UPDATE Livro SET ISBN = ?,Nome = ?,Categoria = ?,Resenha = ?,Editora = ?, AnoPub = ?, Idioma = ?, Autor = ?, NumPaginas = ?"
                + "WHERE ISBN = ?";
        
        try {
            stmt = cn.prepareStatement(sql);
            stmt.setString(1, livro.getIsbn());
            stmt.setString(2, livro.getTitulo());
            stmt.setString(3, livro.getCategoria());
            stmt.setString(4, livro.getResenha());
            stmt.setString(5, livro.getEditora());
            stmt.setString(6, livro.getdataPub());
            stmt.setString(7, livro.getIdioma());
            stmt.setString(8, livro.getAutor());
            stmt.setInt(9, livro.getNumPaginas());
            stmt.setString(10, livro.getIsbn());
            stmt.execute();
            
        } finally {
            ConnectionFactory.closeConnection(cn, stmt);
        }
    }
    
    public static void apagar(String isbn) throws SQLException, Exception{
        PreparedStatement stmt = null;
        cn = ConnectionFactory.getConnection();
       
        
        String sql = "DELETE FROM Livro WHERE ISBN = ?";
        
        try {
            stmt = cn.prepareStatement(sql);
            stmt.setString(1, isbn);
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
                livros.add(livro);
            }
            
        } finally {
            ConnectionFactory.closeConnection(cn, stmt, rs);
        }
        return livros;
    }
}
