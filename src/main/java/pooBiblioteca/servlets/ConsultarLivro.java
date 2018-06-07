/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pooBiblioteca.servlets;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pooBiblioteca.controllers.ServicoLivro;
import pooBiblioteca.model.LivroAcervo;

/**
 *
 * @author Marcelo Pereira <macope727@gmail.com>
 */

@WebServlet(urlPatterns = {"/ConsultarAcervo"})
public class ConsultarLivro extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String titulo = req.getParameter("acervo");
        List<LivroAcervo> listaLivro = null;
        try {
            listaLivro = ServicoLivro.consultar(titulo);
        } catch (Exception ex) {
            Logger.getLogger(ConsultarLivro.class.getName()).log(Level.SEVERE, null, ex);
        }
        req.setAttribute("listaLivro", listaLivro);
        req.getRequestDispatcher("/WEB-INF/jsp/home.jsp").forward(req, resp);
        
    }
    
     @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/home.jsp").forward(req, resp);
    }
    
}
