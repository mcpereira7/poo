<%-- 
    Document   : index
    Created on : 29/05/2018, 11:17:16
    Author     : Marcelo Pereira <macope727@gmail.com>
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" media="screen" href="css/estilo.css" />
        <link rel="stylesheet" type="text/css" media="screen" href="css/bootstrap.css" />
        <link rel="stylesheet" type="text/css" media="screen" href="css/bootstrap.min.css" />
        <script src="js/menu.js"></script>
        <script src="js/jquery.min.js"></script>
        <script src="js/skel.min.js"></script>
        <script src="js/util.js"></script>
    </head>
    <body>
        <div class="corpoSite">

            <!-- Menu -->
            <div class="topnav" id="myTopnav">
                <a href="index.html" class="active">Home</a>
                <a href="ConsultarAcervo">Acervo</a>
                <a href="Reserva">Empréstimos</a>
                <a href="CadastroCliente">Cadastro Cliente</a>
                <a href="CadastroLivro">Cadastro Livro</a>

             </div>
            <!-- Search -->
            <section id="search" class="alt">
                <form method="POST" action="RelatorioEmprestimo">
                    <label for="dtIni">Data Inicial</label>
                    <input type="date" name="dtIni" id="dtIni"/>
                    <label for="dtFim">Data Final</label>
                    <input type="date" name="dtFim" id="dtFim"/>
                    <input type="submit" name="enviar" id="enviar" value="gerar">
                </form>
            </section>

            <table>
                <theader>
                    <tr>
                        <td>ISBN</td>
                        <td>Título</td>
                        <td>Data Empréstimo</td>
                        <td>Data Devolução</td>
                        <td>Ação</td>
                    </tr>
                </theader>
                <tbody>
                    <c:forEach var="emp" items="${rel}">
                        <tr>
                            <td><c:out value="${emp.isbn}"></c:out></td>
                            <td><c:out value="${emp.titulo}"></c:out></td>
                            <td><c:out value="${emp.dtEmp}"></c:out></td>
                                <td id="btsAltExc">
                                    <form action="Reserva" method="POST" class="listCli">
                                        <input type="image" src="img/edit_icon.png" 
                                               name="reservar" value="${livro.isbn}"></form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <footer>
                <p>Posted by: Marcelo Pereira | Vinicius Presoto</p>
                <p>Programação Orientada a Objeto: <a href="http://www.sp.senac.br/graduacao/curso/tecnologia/analise-e-desenvolvimento-de-sistemas">
                        TADS - Senac</a></p>
            </footer>
        </div>
    </body>
</html>
