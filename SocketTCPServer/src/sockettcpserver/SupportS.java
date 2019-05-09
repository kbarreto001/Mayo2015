package sockettcpserver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SupportS {

    public String RecibirNombre(DataInputStream disSocket) {
        String nombreFichero = null;
        try {
            nombreFichero = disSocket.readUTF();
        } catch (IOException ex) {
            System.out.println("Error 1: " + ex.getLocalizedMessage());
        }
        System.out.println(nombreFichero);
        return nombreFichero;
    }

    public int RecibirTamano(DataInputStream disSocket) throws IOException {
        int tamano;
        return tamano = Integer.parseInt(disSocket.readUTF());
    }

    public String[] RecibirFichero(DataInputStream disSocket) throws IOException {
        String[] ficheroVolcado = null;
        try {
            int tamano = RecibirTamano(disSocket);
            ficheroVolcado = new String[tamano + 1];
            for (int i = 0; i < ficheroVolcado.length; i++) {
                ficheroVolcado[i] = disSocket.readUTF();
            }
        } catch (IOException ex) {
            System.out.println("Error 1: " + ex.getLocalizedMessage());
        }
        return ficheroVolcado;
    }

    public String[] Algoritmo(String[] ficheroVolcado) {
        String[] numFyC = ficheroVolcado[0].split(" ");
        String[] fila, infoFinal = new String[2];
        int[] maxNFC = new int[3];
        infoFinal[1] = ficheroVolcado[0];
        for (int i = 0; i < Integer.parseInt(numFyC[0]); i++) {
            fila = ficheroVolcado[i + 1].split(" ");
            infoFinal[1] = infoFinal[1] + " " + String.valueOf(fila.length) + " " + ficheroVolcado[i + 1];
            for (int k = 0; k < fila.length; k++) {
                if ((Integer.parseInt(fila[k])) > maxNFC[0]) {
                    maxNFC[0] = Integer.parseInt(fila[k]);
                    maxNFC[1] = i + 1;
                    maxNFC[2] = k + 1;
                }
            }
        }
        System.out.println(infoFinal[1]);
        infoFinal[0] = String.valueOf(maxNFC[0]) + " " + String.valueOf(maxNFC[1]) + " " + String.valueOf(maxNFC[2]);
        return infoFinal;
    }

    public void GuardarFicheroH(File FICHEROH, String nombreFichero) throws FileNotFoundException, IOException {
        String[] ficheroVolcado;
        int tmp1 = 0;
        String tmp2;
        if (FICHEROH.exists()) {
            try (
                    BufferedReader dis = new BufferedReader(new FileReader(FICHEROH));
                    BufferedReader disT = new BufferedReader(new FileReader(FICHEROH));) {
                while ((tmp2 = disT.readLine()) != null) {
                    tmp1++;
                }
                ficheroVolcado = new String[tmp1 + 1];
                ficheroVolcado[ficheroVolcado.length - 1] = nombreFichero;
                for (int i = 0; i < ficheroVolcado.length - 1; i++) {
                    ficheroVolcado[i] = dis.readLine();
                }
                ApoyoGuardar(FICHEROH, ficheroVolcado);
            }
        } else {
            ApoyoGuardar(FICHEROH, nombreFichero);
        }
    }

    public void ApoyoGuardar(File FICHEROH, String[] ficheroVolcado) throws IOException {
        try (
                BufferedWriter br = new BufferedWriter(new FileWriter(FICHEROH));) {
            for (int i = 0; i < ficheroVolcado.length; i++) {
                br.write(ficheroVolcado[i] + "\n");
            }
        }
    }

    public void ApoyoGuardar(File FICHEROH, String ficheroVolcado) throws IOException {
        try (
                BufferedWriter br = new BufferedWriter(new FileWriter(FICHEROH));) {
            br.write(ficheroVolcado);
        }
    }

    public void EnviarInfoFinal(DataOutputStream dosSocket, String aux) throws IOException {
        try {
            dosSocket.writeUTF(aux);
        } catch (IOException ex) {
            System.out.println("Error 2: " + ex.getLocalizedMessage());
        }
    }
}
