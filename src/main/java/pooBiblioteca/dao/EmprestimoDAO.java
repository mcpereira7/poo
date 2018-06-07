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
import pooBiblioteca.connection.ConnectionFactory;
import pooBiblioteca.model.LivroAcervo;
import pooBiblioteca.model.Emprestimo;
import pooBiblioteca.model.EmprestimoRelatorio;

/**
 *
 * @author Marcelo Pereira <macope727@gmail.com>
 */
public class EmprestimoDAO {

    private static Connection cn = null;

    public static void registrar(Emprestimo livro, String cpf) throws SQLException, Exception {
        PreparedStatement stmt = null;
        cn = ConnectionFactory.getConnection();

        String sql = "INSERT INTO ItemLivro (ISBN,dtEmprest,dtDevol, dtPrevista,ValorMulta, DiasAtraso, Cliente) "
                + "VALUES (?,?,?,?,?,?,?)";

        try {
            stmt = cn.prepareStatement(sql);
            stmt.setString(1, livro.getIsbn());
            stmt.setDate(2, new Date(livro.getDtEmp().getTime()));
            stmt.setDate(3, new Date(livro.getDtDev().getTime()));
            stmt.setDate(4, new Date(livro.getDtPrev().getTime()));
            stmt.setDouble(5, livro.getValorMulta());
            stmt.setInt(6, 0);
            stmt.setString(7, cpf);
            stmt.execute();

        } finally {
            ConnectionFactory.closeConnection(cn, stmt);
        }
    }

    public static void atualizar(Emprestimo livro) throws SQLException, Exception {
        PreparedStatement stmt = null;
        cn = ConnectionFactory.getConnection();

        String sql = "UPDATE Livro SET dtDevol = ?,ValosMulta = ?,DiasAtraso = ?,Devolvido = ?"
                + "WHERE ISBN = ?";

        try {
            stmt = cn.prepareStatement(sql);
            stmt.setDate(1, new Date(livro.getDtDev().getTime()));
            stmt.setDouble(2, livro.getValorMulta());
            stmt.setInt(3, livro.getDiasAtraso());
            stmt.setBoolean(4, livro.isDevolvido());
            stmt.setString(5, livro.getIsbn());
            stmt.execute();

        } finally {
            ConnectionFactory.closeConnection(cn, stmt);
        }
    }

    public static List<EmprestimoRelatorio> buscar(Date ini, Date fim) throws SQLException, Exception {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List emps = new ArrayList();
        EmprestimoRelatorio emp = null;
        String sql = "select l.nome as Titulo, l.ISBN,il.dtEmprest,  il.dtDevol,  il.dtPrevista, il.Devolvido, c.Nome\n"
                + "  from Livro l inner join ItemLivro il on l.isbn=il.isbn\n"
                + "  join Cliente c on c.cpf=il.cliente\n"
                + "  where il.dtEmprest BETWEEN ? AND ?;";
        cn = ConnectionFactory.getConnection();

        try {
            stmt = cn.prepareStatement(sql);
            stmt.setDate(1, new Date(ini.getTime()));
            stmt.setDate(2, new Date(fim.getTime()));
            rs = stmt.executeQuery();

            while (rs.next()) {
                emp = new EmprestimoRelatorio();
                emp.setIsbn(rs.getString("ISBN"));
                emp.setDtEmp((java.util.Date)rs.getDate("dtEmprest"));
                emp.setDtDev((java.util.Date)rs.getDate("dtDevol"));
                emp.setDtPrev((java.util.Date)rs.getDate("dtPrevista"));
                emp.setTitulo(rs.getString("Titulo"));
                emp.setDevolvido(rs.getBoolean("Devolvido"));
                emp.setCliente(rs.getString("Nome"));
                emps.add(emp);
            }

        } finally {
            ConnectionFactory.closeConnection(cn, stmt, rs);
        }
        return emps;
    }

    public static List<LivroAcervo> buscarTop10() throws SQLException, Exception {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List livros = new ArrayList();
        LivroAcervo livro = null;
        String sql = "SELECT * FROM Livro ORDER BY dtCadastro DESC LIMIT 10;";
        cn = ConnectionFactory.getConnection();

        try {
            stmt = cn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
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
