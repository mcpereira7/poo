/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pooBiblioteca.exceptions;

/**
 *
 * @author vinicius.presoto
 */
public class EmprestimoException extends Exception {
    
       public EmprestimoException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmprestimoException(String message) {
        super(message);
    }
}
