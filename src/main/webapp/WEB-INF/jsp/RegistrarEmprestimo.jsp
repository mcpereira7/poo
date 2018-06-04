<%-- 
    Document   : CadastroLivro
    Created on : 26/05/2018, 14:09:53
    Author     : Marcelo Pereira <macope727@gmail.com>
    Tela de MODELO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>MODELO</title>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" media="screen" href="css/estilo.css" />
        <link rel="stylesheet" type="text/css" media="screen" href="css/bootstrap.css" />
        <script src="js/menu.js"></script>
        <script src="js/jquery.min.js"></script>
        <script src="js/skel.min.js"></script>
        <script src="js/util.js"></script>
        <script src="js/buscaLivro.js"></script>
        <script src="js/formFuncionario.js"></script>
    </head>
    <body>
        <div class="corpoSite">

            <!-- Menu Suspenso-->
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
            <div class="container">
                <div class="card mb-3">
                    <div class="card-header">
                        <h3>Cadastro de Clientes</h3>
                    </div><!-- fim .card-header -->

                    <div class="card-body">

                        <form method="POST" action="RegEmprestimo" id="formRegistroEmprestimo">
                            <div class="box"> 
                                <div class="isbn">
                                    <label for="isbn">ISBN</label>
                                    <input type="text" name="isbn" id="isbn" value="${livro.getIsbn()}">
                                </div>
                                <div class="titulo">
                                    <label for="titulo">Titulo</label>
                                    <input type="text" name="titulo" id="titulo" value="${livro.getTitulo()}">
                                </div>
                                <div class="cliente">
                                    <label for="cliente">Cliente</label>
                                    <input type="text" name="cliente" id="cliente">
                                </div>
                                <div class="dtPrevEntrega">
                                    <label for="dtPrevEntrega">Previsão de Entrega</label>
                                    <input type="date" name="dtPrevEntrega" id="dtPrevEntrega">
                                </div>
                                <div class="submit" id="form_button">
                                    <input type="submit" value="Salvar">
                                    <input type="reset" value="Cancelar">
                                </div>
                            </div>

                    </div>
                    </form>


                    <!-- ... aqui vai o <dl> que já temos ... -->

                </div><!-- fim .card-body -->
            </div><!-- fim .card -->

        <footer>
            <p>Posted by: Marcelo Pereira | Vinicius Presoto</p>
            <p>Programação Orientada a Objeto: <a href="http://www.sp.senac.br/graduacao/curso/tecnologia/analise-e-desenvolvimento-de-sistemas">
                    TADS - Senac</a></p>
        </footer>
    </div>
</body>
</html>
