/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practica8;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author adcoyoc
 */
public class Cuenta extends Thread {

    private Banco buff;//El buffer del banco

    //las letras representan lo que se va depositando y retirando
    private final String letras = "abcdefghijklmnopqrstuvxyz";

    public Cuenta(Banco b) {

        this.buff = b;

    }

    public void run() {

        while (true) {
            try {

                char c = letras.charAt((int) (Math.random() * letras.length()));//Se elige al azar la letra
                buff.depositar(c);//El cliente realiza un deposito
                System.out.println("Depositado  $" + c);

                sleep((int) (Math.random() * 4000));//Se da un tiempo de esperar para que se haga un retiro
            } catch (InterruptedException ex) {
                Logger.getLogger(Cuenta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
