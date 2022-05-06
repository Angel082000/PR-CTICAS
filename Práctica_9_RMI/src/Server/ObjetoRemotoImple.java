/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;

import RMI.RemoteInterface;

import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author juanc
 */
public class ObjetoRemotoImple extends UnicastRemoteObject implements RemoteInterface{
    //ObjetoRemotoImple debe heredar de UnicastRemoteObject 
    //y sobrescribir los métodos que dene la interface ObjetoRemoto. 
    public ObjetoRemotoImple() throws Exception{
        super();
    }
    @Override
    public int suma(int x, int y){
        return(x+y);
    }
    public int resta(int x, int y){
        return(x-y);
    }
    public int multiplicacion(int x, int y){
        return(x*y);
    }
    public int division(int x, int y){
        return(x/y);
    }

   
    
}
