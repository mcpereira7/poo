/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pooBiblioteca.servlets;

import java.io.IOException;
import java.util.Date;
import javax.servlet.RequestDispatcher;
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
@WebServlet(urlPatterns = {"/RegistroEmprestimo"})
public class RegEmprestimo extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Emprestimo emp = new Emprestimo();
        String cpf = req.getParameter("cliente");
        Date dtNow = AuxiliarDatas.ftmtData();
        Date dtDevol = null;
        Date dtPrev = AuxiliarDatas.getDataPrevisaoEntrega(dtNow);
        emp.setIsbn(req.getParameter("isbn"));
        emp.setTitulo(req.getParameter("titulo"));
        emp.setDtEmp(dtNow);
        emp.setDtPrev(dtPrev);
        emp.setValorMulta(0);
        
        try {
            ServicoEmprestimo.cadastrar(emp, cpf);
        } catch (Exception e) {
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/RegistrarEmprestimo.jsp");
        dispatcher.forward(req, resp);
        
    }
    
    
    
    
}
