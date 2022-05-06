package Cliente;

import RMI.RemoteInterface;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JOptionPane;

/**
 *
 * @author juanc
 */
public class ClienteRMI {

    
    
    
    
    public int operacion(int a, int b, int c) {
        int x = 0;
        try {

            
            //Se cre instancia de la clase Registry, se manda como parametros el IP y el puerto
            Registry miRegistro = LocateRegistry.getRegistry("127.0.0.1",1234);
            RemoteInterface s = (RemoteInterface) miRegistro.lookup("Operaciones");

         switch(c) {
			case 1:
                              //Se llama al metodo suma de la clase RemoteIterface
				x= s.suma(a,b);
                                break;
			case 2:
                            //Se llama al metodo resta de la clase RemoteIterface
				 x= s.resta(a,b);
                                 break;
			case 3:
                            //Se llama al metodo multiplicacion de la clase RemoteIterface
				 x= s.multiplicacion(a,b);
                                 break;
			case 4:
                            //Se llama al metodo division de la clase RemoteIterface
				 x= s.division(a,b);
                                 break;
                  
			default:
			
                                break;
		}

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        
  return x;
    }

}
