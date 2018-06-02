<%-- 
    Document   : index
    Created on : 29/05/2018, 11:17:16
    Author     : Marcelo Pereira <macope727@gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" media="screen" href="css/estilo.css" />
        <link rel="stylesheet" type="text/css" media="screen" href="css/bootstrap.css" />
        <script src="js/menu.js"></script>
        <script src="js/jquery.min.js"></script>
        <script src="js/skel.min.js"></script>
        <script src="js/util.js"></script>
    </head>
    <body>
        <div class="corpoSite">

            <!-- Menu -->
            <div class="topnav" id="myTopnav">
                <a href="#home" class="active">Home</a>
                <a href="#news">Acervo</a>
                <a href="#contact">Empréstimos</a>
                <div class="dropdown">
                    <button class="dropbtn">Cadastro 
                        <i class="fa fa-caret-down"></i>
                    </button>
                    <div class="dropdown-content">
                        <a href="#">Autor</a>
                        <a href="#">Clientes</a>
                        <a href="#">Livros</a>
                    </div>
                </div> 
                <!--a href="#about">About</a-->
                <a href="javascript:void(0);" class="icon" onclick="myFunction()">&#9776;</a>
            </div>
            <!-- Search -->
            <section id="search" class="alt">
                <form method="POST" action="ConsultarAcervo">
                    <input type="text" name="acervo" id="acervo" placeholder="Buscar no Acervo" />
                </form>
            </section>

            <c:forEach var="livro" items="${listaLivro}">
                <div class="card" style="width: 18rem;">
                    <img class="card-img-top" src="..." alt="Card image cap">
                    <div class="card-body">
                        <h5 class="card-title">Card title</h5>
                        <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                        <a href="#" class="btn btn-primary">Go somewhere</a>
                    </div>
                </div>
            </c:forEach>
                
                <footer>
                <p>Posted by: Marcelo Pereira | Vinicius Presoto</p>
                <p>Programação Orientada a Objeto: <a href="http://www.sp.senac.br/graduacao/curso/tecnologia/analise-e-desenvolvimento-de-sistemas">
                        TADS - Senac</a></p>
            </footer>
        </div>
    </body>
</html>
