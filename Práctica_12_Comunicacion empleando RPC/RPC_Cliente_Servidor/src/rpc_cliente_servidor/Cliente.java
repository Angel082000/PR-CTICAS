/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rpc_cliente_servidor;

import java.util.Vector;
import javax.swing.JOptionPane;
import org.apache.xmlrpc.XmlRpcClient;

/**
 *
 * @author adcoyoc
 */
public class Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Se crea variables String para parametros
        String x = "", y = "";
        //Se crea variable de tipo Objeto
        Object resultado;
        try {
 //Se instancia un clase, mandamos como parametros nuestra IP y el puerto
            XmlRpcClient client = new XmlRpcClient("http://192.168.0.9:8080");
//Creamos Vector para parametros
            Vector<String> parametros = new Vector<String>();

            JOptionPane.showMessageDialog(null, "El Cliente se ha conectado");
            while (true) {
                String menu = JOptionPane.showInputDialog(null, "Elige la operacion:\n"
                        + "1.-Suma\n"
                        + "2.-Resta\n"
                        + "3.-Multiplicacion\n"
                        + "4.-Salir\n", "Cliente servidor RPC", JOptionPane.DEFAULT_OPTION
                );

                switch (menu) {
                    case "1":
                        x = JOptionPane.showInputDialog(null, "Primer número", "Suma", JOptionPane.QUESTION_MESSAGE);
                        y = JOptionPane.showInputDialog(null, "Segundo número", "Suma", JOptionPane.QUESTION_MESSAGE);
             //
                        parametros.addElement(x);
                        parametros.addElement(y);
               //Se ejecuta el metodo suma mediante el servidor antes nombrado
                        resultado = client.execute("miServidorRPC.suma", parametros);

                        JOptionPane.showMessageDialog(null, "La suma es: " + resultado);
                        parametros.clear();
                        break;
                    case "2":
                        x = JOptionPane.showInputDialog(null, "Primer número", "Resta", JOptionPane.QUESTION_MESSAGE);
                        y = JOptionPane.showInputDialog(null, "Segundo número", "Resta", JOptionPane.QUESTION_MESSAGE);

                        parametros.addElement(x);
                        parametros.addElement(y);
   //Se ejecuta el metodo resta mediante el servidor antes nombrado
                        resultado = client.execute("RPC.resta", parametros);

                        JOptionPane.showMessageDialog(null, "La resta es: " + resultado);
                        parametros.clear();
                        break;

                    case "3":
                        x = JOptionPane.showInputDialog(null, "Primer número", "Multiplicacion", JOptionPane.QUESTION_MESSAGE);
                        y = JOptionPane.showInputDialog(null, "Segundo número", "Multiplicacion", JOptionPane.QUESTION_MESSAGE);

                        parametros.addElement(x);
                        parametros.addElement(y);
   //Se ejecuta el metodo multiplicacion mediante el servidor antes nombrado
                        resultado = client.execute("mulRPC.multiplicacion", parametros);

                        JOptionPane.showMessageDialog(null, "La multiplicacion es: " + resultado);
                        parametros.clear();
                        break;
                    case "4":
                        JOptionPane.showMessageDialog(null, "Saliendo", null, JOptionPane.WARNING_MESSAGE);
                        System.exit(0);
                        break;

                }

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
        }
    }

}
