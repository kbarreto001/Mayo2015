package fichero;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class manejoFicheroC {
    
    public String[] leerInformacion (File ficheroLeer) throws FileNotFoundException, IOException{
        String[] informacionF;
        try(
                BufferedReader brT = new BufferedReader(new FileReader(ficheroLeer));
                BufferedReader br = new BufferedReader(new FileReader(ficheroLeer));){
            String tmp1;            
            int tmp2=0;
            while((tmp1=brT.readLine())!=null){
                tmp2++;
            }
            informacionF = new String[tmp2];            
            for (int i=0;i<informacionF.length;i++){
                informacionF[i] = br.readLine();
                System.out.println(informacionF[i]);
            }
        }
        return informacionF;
    }    
}
