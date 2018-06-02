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
import pooBiblioteca.controllers.ServicoCliente;
import pooBiblioteca.model.Cliente;

/**
 *
 * @author Marcelo Pereira <macope727@gmail.com>
 */
@WebServlet(urlPatterns = {"/CadastroCliente"})
public class CadastrarCliente extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher disp = getServletContext().getRequestDispatcher("/WEB-INF/jsp/CadastroCliente.jsp");
        disp.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cliente cli = new Cliente();
        cli.setNome(req.getParameter("nome"));
        cli.setCpf(req.getParameter("cpf"));
        cli.setEmail(req.getParameter("email"));
        cli.setTelefone(req.getParameter("tel"));
        cli.setEndereco(req.getParameter("end"));

        try {
            ServicoCliente.cadastrar(cli);
        } catch (Exception e) {
        }
        RequestDispatcher disp = getServletContext().getRequestDispatcher("/WEB-INF/jsp/CadastroCliente.jsp");
        disp.forward(req, resp);
    }

}
