
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RMIClient {
    protected static File FICHEROB  = new File("File01B.dat");
    public static void main(String[] args) throws NotBoundException, MalformedURLException, RemoteException, IOException {
        String url = "//localhost:1330/SERVIDOR",maxValoresF;
        try {
            ServidorInterfaz objetoRemoto = (ServidorInterfaz) Naming.lookup(url);
            System.out.println("Soy el cliente");
            SupportC otro = new SupportC();
            
            maxValoresF = otro.RecValoresF(FICHEROB);
            System.out.println(maxValoresF);
            
            System.out.println(objetoRemoto.MaxValoresF(maxValoresF));

            
        } catch (RemoteException ex) {
            System.out.println("Error: "+ex.getLocalizedMessage());
        }
    }

}
