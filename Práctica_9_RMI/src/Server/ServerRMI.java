package Server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerRMI {

   public void Server(){

        try {
            
            //instancia al objeto remoto y lo publica en el rmiregistry (repositorio de objetos) relacio- nándolo con un nombre arbitrario a través del cual el cliente lo podrá ubicar y utilizar
            Registry miRegristry = LocateRegistry.createRegistry(1234);
            miRegristry.rebind("Operaciones", new ObjetoRemotoImple());
            System.out.println("Servidor encendido");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
