
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Implementation extends UnicastRemoteObject implements ServidorInterfaz {

    Implementation() throws RemoteException {
        super();
    }

    @Override
    public int sum(int a, int b) throws RemoteException {
        return a + b;
    }

    @Override
    public String MaxValoresF(String maxValoresF) throws RemoteException {
        String[] tmp1 = maxValoresF.split(" ");
        String[] tmp2 = new String[tmp1.length-2];
        
        System.arraycopy(tmp1, 2, tmp2, 0, tmp2.length);       
       
        int nMax = 0;
        
        for (int i = 0; i < tmp2.length; i++) {
            if((Integer.parseInt(tmp2[i]))>nMax){
                nMax=Integer.parseInt(tmp2[i]);
            }                     
        }
        return "Maximo es: "+String.valueOf(nMax);

    }

}
