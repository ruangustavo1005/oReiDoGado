package main;

import controller.ControllerLogin;
import controller.ControllerPrimeiroLogin;

/**
 * @author Ruan
 */
public class App {

    public static void main(String[] args) {
        if (ControllerLogin.existeUsuario()) {
            (new ControllerLogin(null, false)).montaTela();
        }
        else {
            (new ControllerPrimeiroLogin(null, false)).montaTela();
        }
    }
    
}