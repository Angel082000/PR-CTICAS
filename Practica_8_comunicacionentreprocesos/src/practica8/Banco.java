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
public class Banco {

    private char[] buff;
    private int tope;
    private boolean lleno;
    private boolean vacio;

    public Banco(int capacidad) {
        this.buff = new char[capacidad];
        this.tope = 0;
        this.lleno = false;
        this.vacio = true;

    }

    public synchronized void depositar(char c) {
// mientras el buffer este lleno me bloqueo para darle la
// posibilidad al consumidor de consumir algun caracter
        while (this.lleno) {

            try {
                //Si esta lleno el proceso esta en espera
                wait();
            } catch (Exception ex) {

            }

        }

// Si no esta lleno se hacen más depositos.
        buff[tope] = c;
        tope++;

        this.vacio = false;
        if (tope == this.buff.length) {
            this.lleno = true;
        }

        notifyAll();
    }

    public synchronized char retirar() {
// mientras el buffer este vacio me bloqueo para darle la
// posibilidad al productor de producir algun caracter
        while (this.vacio) {

            try {
                //Si esta vacío se pone es tiempo de espera
                wait();
            } catch (Exception ex) {
Logger.getLogger(Banco.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
//Si se hace un retiro disminuye la cantidad.
        tope--;
        this.lleno = false;
        if (tope == 0) {
            this.vacio = true;
        }

        notifyAll();
        return this.buff[this.tope];
    }
}
