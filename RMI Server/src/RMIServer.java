
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class RMIServer {

    public static void main(String[] args) throws RemoteException, MalformedURLException {
        try {
            Remote createRegistry = LocateRegistry.createRegistry(1330);
            ServidorInterfaz servidor = new Implementation();
            Naming.rebind("//localhost:1330/SERVIDOR", servidor);
            
            System.out.println("Soy el servidor");

        } catch (RemoteException ex) {
            System.out.println("Error: " + ex.getLocalizedMessage());
        }
    }

}
