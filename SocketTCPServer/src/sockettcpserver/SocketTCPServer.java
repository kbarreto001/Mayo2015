package sockettcpserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTCPServer {

    protected static File FICHEROH = new File("historial.txt");

    public static void main(String[] args) throws IOException {
        int counter = 1, size = 1000;
        String nombreFichero,aux2;
        String[] ficheroVolcado, aux = new String[2];
        try {
            ServerSocket server = new ServerSocket(5000, size);
            System.out.println("Soy el servidor");
            while (true) {
                Socket connection = server.accept();
                DataInputStream disSocket = new DataInputStream(connection.getInputStream());
                DataOutputStream dosSocket = new DataOutputStream(connection.getOutputStream());
                System.out.println("Recivida conexion No: " + counter + " From: " + connection.getInetAddress().getHostName());
                SupportS otro = new SupportS();

                nombreFichero = otro.RecibirNombre(disSocket);
                aux2 = nombreFichero;
                ficheroVolcado = otro.RecibirFichero(disSocket);
                aux = otro.Algoritmo(ficheroVolcado);
                nombreFichero = nombreFichero + " " + aux[0];
                otro.GuardarFicheroH(FICHEROH, nombreFichero);
                otro.EnviarInfoFinal(dosSocket, aux2);
                otro.EnviarInfoFinal(dosSocket, aux[1]);

                connection.close();
                disSocket.close();
                dosSocket.close();
                counter++;
            }
        } catch (IOException ex) {
            System.out.println("Error 1: " + ex.getLocalizedMessage());
        }
    }
}
