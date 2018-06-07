/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pooBiblioteca.servlets;

import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pooBiblioteca.auxiliares.AuxiliarDatas;
import pooBiblioteca.controllers.ServicoEmprestimo;
import pooBiblioteca.model.Emprestimo;

/**
 *
 * @author Marcelo Pereira <macope727@gmail.com>
 */
@WebServlet(urlPatterns = {"/Devolucao"})
public class DevolucaoLivro extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String isbn = req.getParameter("devolver");
        Emprestimo emp = null;
        
        try {
            emp = ServicoEmprestimo.consultarByIsbn(isbn);
        } catch (Exception e) {
        }
        req.setAttribute("livro", emp);
        req.getRequestDispatcher("/WEB-INF/jsp/DevolucaoEmprestimo.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String isbn = req.getParameter("isbn");
        
        
        req.getRequestDispatcher("/WEB-INF/jsp/DevolucaoEmprestimo.jsp").forward(req, resp);
    }
    
    
    
}
