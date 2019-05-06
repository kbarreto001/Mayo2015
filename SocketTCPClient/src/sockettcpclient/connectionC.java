package sockettcpclient;

import fichero.manejoFicheroC;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;

public class connectionC {

    static private final File FILET = new File("File02T.txt");
    static private final File FILEB = new File("FIle02B.txt");

    public void connectionC(String[] nombreyP) {
        try (
                Socket client = new Socket(nombreyP[0], Integer.parseInt(nombreyP[1]));
                DataOutputStream dos = new DataOutputStream(client.getOutputStream());
                DataInputStream dis = new DataInputStream(client.getInputStream());) {

            enviar(dos, FILET.getName());
            manejoFicheroC otro = new manejoFicheroC();
            enviar(dos, otro.leerInformacion(FILET));
            recibirFinal(dis, FILEB);

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void enviar(DataOutputStream dos, String[] informacion) throws IOException {
        try {
            for (int i = 0; i < informacion.length; i++) {
                dos.writeUTF(informacion[i]);
            }
        } catch (IOException ex) {
            System.out.println("No se pudo enviar la informacion");
        }
    }

    public void enviar(DataOutputStream dos, String informacion) throws IOException {
        try {
            dos.writeUTF(informacion);
        } catch (IOException ex) {
            System.out.println("No se pudo enviar la informacion");
        }
    }

    public void recibirFinal(DataInputStream dis, File ficherobinario) throws FileNotFoundException, IOException {
        String result = new String();
        try (
                DataOutputStream dos = new DataOutputStream(new FileOutputStream(ficherobinario));) {
            result = dis.readUTF();
            System.out.println(result);
            dos.writeUTF(result);
        } catch (IOException ex) {
            System.out.println("Error al intertar copiar el archivo nuevo" + ex.getMessage());
        }
    }
}
