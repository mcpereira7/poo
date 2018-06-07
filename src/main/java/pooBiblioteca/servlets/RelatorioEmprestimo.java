/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pooBiblioteca.servlets;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pooBiblioteca.auxiliares.AuxiliarDatas;
import pooBiblioteca.controllers.ServicoEmprestimo;
import pooBiblioteca.relatorios.EmprestimoRel;

/**
 *
 * @author Marcelo Pereira <macope727@gmail.com>
 */
@WebServlet(urlPatterns = {"/RelatorioEmprestimo"})
public class RelatorioEmprestimo extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<EmprestimoRel> remps = null;
        Date dtIni = AuxiliarDatas.ftmtDataRequest(req.getParameter("dtIni"));
        Date dtFim = AuxiliarDatas.ftmtDataRequest(req.getParameter("dtFim"));
        
        try {
            remps = ServicoEmprestimo.consultar(dtIni, dtFim);
        } catch (Exception e) {
        }
        req.setAttribute("rel", remps);
        req.getRequestDispatcher("/WEB-INF/jsp/RelatorioEmprestimos.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/RelatorioEmprestimos.jsp").forward(req, resp);
    }
    
}
