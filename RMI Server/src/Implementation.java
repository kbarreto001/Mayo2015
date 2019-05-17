
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
        int ilong = 0;
        int counter = 0;
        
        for (int i = 0; i < tmp2.length; i++) {
            if(counter==ilong)
            {
                ilong=Integer.parseInt(tmp2[i]);
                counter=0;
            }
            else
            {
                counter=counter+1;
                System.out.println(Integer.parseInt(tmp2[i]));
                if((Integer.parseInt(tmp2[i]))>nMax){
                    nMax=Integer.parseInt(tmp2[i]);
                }        
            }
        }
        return "Maximo es: "+String.valueOf(nMax);

    }

}
