/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica8;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author adcoyoc
 */
public class Cliente extends Thread {

    private Banco buff;

    public Cliente(Banco b) {
// el monitor
        this.buff = b;

    }

    public void run() {

        while (true) {
            try {
                
                //el cliente realizar un retiro
                char c = this.buff.retirar();
                System.out.println("Retirado  $" + c);
                
                sleep((int) (Math.random() * 4000));//Se da un tiempo de esperar para que se haga un deposito
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
