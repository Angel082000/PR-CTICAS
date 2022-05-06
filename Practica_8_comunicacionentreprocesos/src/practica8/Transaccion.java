/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practica8;

/**
 *
 * @author adcoyoc
 */
public class Transaccion {

    public static void main(String[] args) {
        Banco m = new Banco(5);
        Cuenta p = new Cuenta(m);
        Cliente c = new Cliente(m);
        p.start();
        c.start();
    }
}
