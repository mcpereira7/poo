
import java.util.List;
import pooBiblioteca.controllers.ServicoLivro;
import pooBiblioteca.model.LivroAcervo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Marcelo Pereira <macope727@gmail.com>
 */
public class teste {
    public static void main(String[] args) throws Exception {
        List<LivroAcervo> lista = ServicoLivro.consultar("json");
        
        for(LivroAcervo livro : lista){
            System.out.println(livro.getTitulo() + " | " + livro.getAutor());
        }
    }
}
