package sockettcpclient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.Socket;

public class SocketTCPClient {
    
    protected static File FICHEROT = new File("File01T.txt");    

    public static void main(String[] args) throws IOException {
        String[] ficheroVolcado;
        String infoFinal,nombreFinal;
        try(
                Socket client = new Socket("localhost",5000);
                DataInputStream disSocket = new DataInputStream(client.getInputStream());
                DataOutputStream dosSocket = new DataOutputStream(client.getOutputStream());
                ){
            System.out.println("Soy el cliente");
            SupportC otro = new SupportC();
            
            otro.EnviarNombre(FICHEROT, dosSocket);
            ficheroVolcado=otro.VolcarFichero(FICHEROT);            
            otro.EnviarTamano(ficheroVolcado[0],dosSocket);            
            otro.EnviarFicheroT(ficheroVolcado, dosSocket);
            
            nombreFinal = disSocket.readUTF();            
            infoFinal = disSocket.readUTF();
            System.out.println(infoFinal);
            otro.GuardarFicheroB(otro.ficheroFinal(nombreFinal), infoFinal);
            
        }
    }   
}
