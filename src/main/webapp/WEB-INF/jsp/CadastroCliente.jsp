<%-- 
    Document   : CadastroLivro
    Created on : 26/05/2018, 14:09:53
    Author     : Marcelo Pereira <macope727@gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
    <head>
        <title>Start Page</title>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" media="screen" href="css/estilo.css" />
        <link rel="stylesheet" type="text/css" media="screen" href="css/bootstrap.css" />
        <link rel="stylesheet" type="text/css" media="screen" href="css/bootstrap.min.css" />
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
                <a href="index.html" class="active">Home</a>
                <a href="ConsultarAcervo">Acervo</a>
                <a href="Reserva">Empréstimos</a>
                <a href="CadastroCliente">Cadastro Cliente</a>
                <a href="CadastroLivro">Cadastro Livro</a>
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

                        <form method="POST" action="CadastroCliente" id="formCadCli">
                            <div class="box"> 
                                <div class="nome">
                                    <label for="nome">Nome</label>
                                    <input type="text" name="nome" id="nome">
                                </div>
                                <div class="cpf">
                                    <label for="cpf">CPF</label>
                                    <input type="text" name="cpf" id="cpf">
                                </div>
                                <div class="email">
                                    <label for="email">E-mail</label>
                                    <input type="email" name="email" id="email">
                                </div>
                                <div class="tel">
                                    <label for="tel">Telefone</label>
                                    <input type="text" name="tel" id="tel">
                                </div>
                                <div class="endereco">
                                    <label for="end">Endereço</label>
                                    <input type="text" name="end" id="end">
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
