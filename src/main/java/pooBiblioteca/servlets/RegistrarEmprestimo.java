/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pooBiblioteca.servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pooBiblioteca.controllers.ServicoLivro;
import pooBiblioteca.model.Livro;

/**
 *
 * @author Marcelo Pereira <macope727@gmail.com>
 */

@WebServlet(urlPatterns = {"/Reserva"})
public class RegistrarEmprestimo extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String isbn = req.getParameter("reservar");
        Livro livro = null;
        
        try {
            livro = ServicoLivro.consultarByIsbn(isbn);
            
        } catch (Exception e) {
        }
        req.setAttribute("livro", livro);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/RegistrarEmprestimo.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/RegistrarEmprestimo.jsp");
        dispatcher.forward(req, resp);
    }
    
    
    
}
