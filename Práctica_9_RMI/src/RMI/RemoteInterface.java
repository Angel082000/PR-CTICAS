/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author juanc
 */
public interface RemoteInterface extends Remote{
    //Se crean los metodos remotos.
    public int suma (int x, int y)throws RemoteException;;
    public int resta (int x, int y)throws RemoteException;;
    public int multiplicacion (int x, int y)throws RemoteException;;
    public int division (int x, int y)throws RemoteException;;
 
    
    
}
