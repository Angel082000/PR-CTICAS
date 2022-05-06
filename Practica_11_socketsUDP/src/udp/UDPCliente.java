package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import javax.swing.JOptionPane;

public class UDPCliente {

    public static void mainCaller() throws Exception 
    {
        
     DatagramSocket socket = new DatagramSocket();
        
// buffer con info a enviar
 String name = JOptionPane.showInputDialog("HOLA, ¿Cuál es tu nombre?");
        byte[] bEnviar = name.getBytes();
// ip del server
        byte[] ip = {127, 0, 0, 1};
        InetAddress address = InetAddress.getByAddress(ip);
// paquete de informacion a enviar, ip + port (5432)
        DatagramPacket packet = new DatagramPacket(bEnviar,
                 bEnviar.length,
                 address,
                 5432);
// envio el paquete
        socket.send(packet);
// buffer para recibir la respuesta
        byte[] bRecibe = new byte[256];
        packet = new DatagramPacket(bRecibe,
                 bRecibe.length,
                 address,
                 5432);
// recibo el saludo
        socket.receive(packet);
// muestro el resultado
        String saludo = new String(packet.getData(),
                 0,
                 packet.getLength());
        System.out.println(saludo);
        JOptionPane.showMessageDialog(null, saludo);
        socket.close();
    }

    public static void main(String[] args) throws Exception {
// instancio un DatagramSocket
       mainCaller();
    }
}
