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

/**
 *
 * @author Marcelo Pereira <macope727@gmail.com>
 */
public class LivroDAO {

    private static Connection cn = null;

    public static void cadastrar(Livro livro) throws SQLException, Exception {
        PreparedStatement stmt = null;
        cn = ConnectionFactory.getConnection();

        String sql = "INSERT INTO Livro (ISBN,Nome,Categoria,Resenha,Editora, AnoPub, Idioma, idAutor) "
                + "VALUES (?,?,?,?,?,?,?,?)";
        
        try {
            stmt = cn.prepareStatement(sql);
            stmt.setString(1, livro.getIsbn());
            stmt.setString(2, livro.getTitulo());
            stmt.setString(3, livro.getCategoria());
            stmt.setString(4, livro.getResenha());
            stmt.setString(5, livro.getDitora());
            stmt.setInt(6, livro.getAnoPub());
            stmt.setString(7, livro.getIdioma());
            stmt.setInt(8, livro.getIdAutor());
            stmt.execute();
            
        } finally {
            ConnectionFactory.closeConnection(cn, stmt);
        }
    }
    
    public static void atualizar(Livro livro) throws SQLException, Exception{
        PreparedStatement stmt = null;
        cn = ConnectionFactory.getConnection();
        
        String sql = "UPDATE Livro SET ISBN = ?,Nome = ?,Categoria = ?,Resenha = ?,Editora = ?, AnoPub = ?, Idioma = ?, idAutor = ?"
                + "WHERE ISBN = ?";
        
        try {
            stmt = cn.prepareStatement(sql);
            stmt.setString(1, livro.getIsbn());
            stmt.setString(2, livro.getTitulo());
            stmt.setString(3, livro.getCategoria());
            stmt.setString(4, livro.getResenha());
            stmt.setString(5, livro.getDitora());
            stmt.setInt(6, livro.getAnoPub());
            stmt.setString(7, livro.getIdioma());
            stmt.setInt(8, livro.getIdAutor());
            stmt.setString(9, livro.getIsbn());
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
    
    public static List<Livro> buscar(String nome) throws SQLException, Exception{
        PreparedStatement stmt = null;
        cn = ConnectionFactory.getConnection();
        ResultSet rs = null;
        List livros = new ArrayList();
        Livro livro = null;
        String sql = "SELECT * FROM Bibliotecario WHERE Nome like ?";
        
        try {
            stmt = cn.prepareStatement(sql);
            stmt.setString(1, "%" + nome + "%");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                livro = new Livro();
                livro.setIsbn(rs.getString("ISBN"));
                livro.setTitulo(rs.getString("Nome"));
                livro.setCategoria(rs.getString("Categoria"));
                livro.setResenha(rs.getString("Resenha"));
                livro.setDitora(rs.getString("Editora"));
                livro.setAnoPub(rs.getInt("AnoPub"));
                livro.setIdioma(rs.getString("Idioma"));
                livro.setIdAutor(rs.getInt("idAutor"));
                livros.add(livro);
            }
            
        } finally {
            ConnectionFactory.closeConnection(cn, stmt, rs);
        }
        return livros;
    }
}
