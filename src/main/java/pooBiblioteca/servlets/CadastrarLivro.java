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
import pooBiblioteca.model.LivroAcervo;

/**
 *
 * @author Marcelo Pereira <macope727@gmail.com>
 */
@WebServlet(urlPatterns = {"/CadastroLivro"})
public class CadastrarLivro extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher disp = getServletContext().getRequestDispatcher("/WEB-INF/jsp/CadastroLivro.jsp");
        disp.forward(req, resp);
    }

    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LivroAcervo livro = new LivroAcervo();
        livro.setIsbn(req.getParameter("isbn"));
        livro.setTitulo(req.getParameter("title"));
        livro.setSubTitulo("subtitle");
        livro.setdataPub(req.getParameter("anoPub"));
        livro.setIdioma(req.getParameter("idioma"));
        livro.setCategoria(req.getParameter("categoria"));
        livro.setAutor(req.getParameter("author"));
        livro.setEditora(req.getParameter("editora"));
        livro.setNumPaginas(Integer.parseInt(req.getParameter("numPaginas")));
        livro.setResenha(req.getParameter("resenha"));
        
        try {
            ServicoLivro.cadastrar(livro);
        } catch (Exception e) {
        }
        RequestDispatcher disp = getServletContext().getRequestDispatcher("/WEB-INF/jsp/CadastroLivro.jsp");
        disp.forward(req, resp);

    }
    
}
