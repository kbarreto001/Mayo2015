package ficheroS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class manejoFicheroS {

    public void informacionAg(File fichero, String[] informacion) throws IOException {
        int lines=0;
        String[] tmp2;
        try (
                BufferedReader br = new BufferedReader(new FileReader(fichero));
                BufferedReader brT = new BufferedReader(new FileReader(fichero));) {
            String tmp1;
            while((tmp1=brT.readLine())!=null){
                lines++;
            }
            tmp2 = new String[lines+1];
            for(int i=0;i<tmp2.length-1;i++){
                tmp2[i]=br.readLine();
            }
            tmp2[tmp2.length-1] = informacion[0];
            guardarF(fichero,tmp2);        
        }
    }
    
    public void guardarF (File fichero, String[] informacion) throws IOException{
        try(
                BufferedWriter bw = new BufferedWriter(new FileWriter(fichero));
                ){
            for(int i=0;i<informacion.length;i++){
                bw.write(informacion[i]+"\n");
            }
        }
    }
    
    public String[] Algoritm1(String[] informacion){
        String[] tmp2,tmp3,tmp1=new String[2];        
        int max = 0,columna=0,fila=0;
        tmp3 = informacion[1].split(" ");
        String[] tmp4 = new String[Integer.parseInt(tmp3[0])];
        for (int i=0;i<Integer.parseInt(tmp3[0]);i++){
            tmp2 = informacion[i+2].split(" ");
            tmp4[i]=String.valueOf(tmp2.length);
            System.out.println(tmp4[i]);
            for (int j=0;j<tmp2.length;j++){
                if(Integer.parseInt(tmp2[j])>max){
                    max = Integer.parseInt(tmp2[j]);
                    columna = j+1;
                    fila = i+1;
                }
            }
        }
        tmp1[0] = informacion[0]+" "+String.valueOf(max)+" "+String.valueOf(fila)+" "+String.valueOf(columna);
        System.out.println(tmp1[0]);
        tmp1[1] = informacion[1];
        for (int k=0;k<Integer.parseInt(tmp3[0]);k++){
            tmp1[1] = tmp1[1]+" "+tmp4[k]+" "+informacion[k+2];
        }
        System.out.println(tmp1[1]);
        return tmp1;
    }  
}
