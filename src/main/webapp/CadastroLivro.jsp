<%-- 
    Document   : CadastroLivro
    Created on : 26/05/2018, 14:09:53
    Author     : Marcelo Pereira <macope727@gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Start Page</title>
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
                        <h3>Cadastro de Livos</h3>
                    </div><!-- fim .card-header -->

                    <div class="card-body">

                        <form method="POST" action="CadastroLivro" id="formCadLivro">
                            <div class="box"> 
                                <div class="lde">
                                <label for="isbn">ISBN</label>
                                <input type="text" name="isbn" id="isbn">
                                    <label for="title">Título</label>
                                    <input type="text" name="title" id="title">
                                    <label for="subtitle">SubTítulo</label>
                                    <input type="text" name="subtitle" id="subtitle">
                                    <label for="anoPub">Ano de Publicação</label>
                                    <input type="text" name="anoPub" id="anoPub">
                                    <label for="idioma">Idioma</label>
                                    <input type="text" name="idioma" id="idioma">
                                    <label for="categoria">Categorias</label>
                                    <input type="text" name="categoria" id="categoria">
                                </div>
                                <div class="ldd">
                                    <div id="upImage">       
                                        <div id="image-holder"></div><br>
                                        <input id="fileUpload" type="file"><br>
                                    </div>
                                    <label for="author">Autor</label>
                                    <input type="text" name="author" id="author">
                                    <label for="editora">Editora</label>
                                    <input type="text" name="editora" id="editora">
                                    <label for="numPaginas">Num. Páginas</label>
                                    <input type="text" name="numPaginas" id="numPaginas">
                                    <label for="resenha">Resenha</label><br>
                                    <textarea rows="8" cols="50" name="resenha" id="resenha"></textarea>
                                    <br>
                                    <input type="submit" value="Salvar">
                                <input type="reset" value="Cancelar">
                                </div>
                                
                            </div>
                        </form>


                        <!-- ... aqui vai o <dl> que já temos ... -->

                    </div><!-- fim .card-body -->
                </div><!-- fim .card -->
            </div>


            <footer>
                <p>Posted by: Marcelo Pereira | Vinicius Presoto</p>
                <p>Programação Orientada a Objeto: <a href="http://www.sp.senac.br/graduacao/curso/tecnologia/analise-e-desenvolvimento-de-sistemas">
                        TADS - Senac</a></p>
            </footer>
        </div>
    </body>
</html>
