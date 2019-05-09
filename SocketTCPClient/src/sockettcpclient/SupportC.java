package sockettcpclient;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class SupportC {

    public String[] VolcarFichero(File FICHEROT) throws FileNotFoundException, IOException {
        String[] ficheroVolcado;
        int tmp1 = 0;
        String tmp2;
        try (
                BufferedReader dis = new BufferedReader(new FileReader(FICHEROT));
                BufferedReader disT = new BufferedReader(new FileReader(FICHEROT));) {
            while ((tmp2 = disT.readLine()) != null) {
                tmp1++;
            }
            ficheroVolcado = new String[tmp1];
            for (int i = 0; i < ficheroVolcado.length; i++) {
                ficheroVolcado[i] = dis.readLine();
            }
        }
        return ficheroVolcado;
    }

    public void EnviarNombre(File FICHEROT, DataOutputStream dosSocket) throws IOException {
        try {
            dosSocket.writeUTF(FICHEROT.getName());
        } catch (IOException ex) {
            System.out.println("Error 2: " + ex.getLocalizedMessage());
        }
    }

    public void EnviarFicheroT(String[] ficheroVolcado, DataOutputStream dosSocket) throws IOException {
        try {
            for (int i = 0; i < ficheroVolcado.length; i++) {
                dosSocket.writeUTF(ficheroVolcado[i]);
            }
        } catch (IOException ex) {
            System.out.println("Error 2: " + ex.getLocalizedMessage());
        }
    }

    public void EnviarTamano(String numFilas, DataOutputStream dosSocket) throws IOException {
        String[] tmp = new String[2];
        tmp = numFilas.split(" ");
        try {
            dosSocket.writeUTF(tmp[0]);
        } catch (IOException ex) {
            System.out.println("Error 2: " + ex.getLocalizedMessage());
        }
    }

    public void GuardarFicheroB(File FICHEROB, String infoFinal) throws FileNotFoundException, IOException {
        try (
                DataOutputStream dos = new DataOutputStream(new FileOutputStream(FICHEROB));) {
            dos.writeUTF(infoFinal);
        }
    }

    public File ficheroFinal(String nombreFinal) {
        File FICHEROB;
        nombreFinal = nombreFinal.replace("T", "B");
        nombreFinal = nombreFinal.replace("txt", "dat");        
        return FICHEROB = new File(nombreFinal);
    }

}
