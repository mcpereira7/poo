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
import java.util.Date;
import java.util.List;
import pooBiblioteca.connection.ConnectionFactory;
import pooBiblioteca.model.Bibliotecario;
import pooBiblioteca.relatorios.EmprestimoRel;

/**
 *
 * @author Marcelo Pereira <macope727@gmail.com>
 */
public class RelatorioDAO {

    private static Connection cn = null;

    public static List<EmprestimoRel> relatorioEmprestimos(Date ini, Date fim) throws SQLException, Exception{
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<EmprestimoRel> livrosEmp = null;
        EmprestimoRel emp = null;
        String sql = "select l.nome as Titulo, l.ISBN,il.dtEmprest,  il.dtDevol,  il.dtPrevista, il.Devolvido, c.Nome\n"
                + "  from Livro l inner join ItemLivro il on l.isbn=il.isbn\n"
                + "  join Cliente c on c.cpf=il.cliente\n"
                + "  where il.dtEmprest BETWEEN ? AND ?;";
        
        cn = ConnectionFactory.getConnection();
        
        try {
            stmt = cn.prepareStatement(sql);
            stmt.setDate(1, new java.sql.Date(ini.getTime()));
            stmt.setDate(2, new java.sql.Date(fim.getTime()));
            rs = stmt.executeQuery();
            
            while(rs.next()){
                 emp = new EmprestimoRel();
                emp.setIsbn(rs.getString("ISBN"));
                emp.setDtEmp((java.util.Date)rs.getDate("dtEmprest"));
                emp.setDtDev((java.util.Date)rs.getDate("dtDevol"));
                emp.setDtPrev((java.util.Date)rs.getDate("dtPrevista"));
                emp.setTitulo(rs.getString("Titulo"));
                emp.setDevolvido(rs.getBoolean("Devolvido"));
                emp.setCliente(rs.getString("Nome"));
            }
            
        } finally {
            ConnectionFactory.closeConnection(cn, stmt, rs);
        }
        return livrosEmp;
    }
}
