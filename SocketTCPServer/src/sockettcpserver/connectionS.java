package sockettcpserver;

import ficheroS.manejoFicheroS;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class connectionS {
    static private final File fileT = new File("/home/kbarreto001/Desktop/NetBeansProjects/Mayo2015/historial.txt");
    
        public void connectionS() {
        int counter = 1, size = 1000;
        ServerSocket server;
        Socket connection;
        DataOutputStream dos;
        DataInputStream dis;
        try {
            server = new ServerSocket(5000, size);
            while (true) {
                String[] result = new String[2];
                connection = server.accept();
                System.out.println("concexion: " + counter + " received from: " + connection.getInetAddress().getHostName());
                dos = new DataOutputStream(connection.getOutputStream());
                dis = new DataInputStream(connection.getInputStream());
                               
                manejoFicheroS otro = new manejoFicheroS();
                otro.informacionAg(fileT,result=otro.Algoritm1(recibirI(dis)));              
                dos.writeUTF(result[1]);
                
                connection.close();
                dos.close();
                dis.close();
                counter++;
            }
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getLocalizedMessage());
        }
    }
        
    public String[] recibirI(DataInputStream dis) {        
        String[] informacion = null,tmp3;
        String tmp,tmp2;
        int i=0;
        try {            
                tmp = dis.readUTF();
                System.out.println(tmp);
                tmp2 = dis.readUTF();
                tmp3 = tmp2.split(" ");
                i = Integer.parseInt(tmp3[0]);                
                informacion = new String[i+2];
                informacion[0] = tmp;
                System.out.println(informacion[0]);
                informacion[1] = tmp2;
                System.out.println(informacion[1]);
                for(int j=2;j<informacion.length;j++){
                    informacion[j]=dis.readUTF();
                    System.out.println(informacion[j]);
                }            
        } catch (IOException ex) {
            System.out.println("No se pudo recibir la informacion 3");
        }
        return informacion;
    }
}
