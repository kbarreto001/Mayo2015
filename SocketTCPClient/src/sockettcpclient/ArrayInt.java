
package sockettcpclient;

public class ArrayInt {
    
    private int[] array;

    public ArrayInt(int tam) 
    {
        array = new int[tam];
    }
    
    public int[] obtenerArray()
    {
        return array;
    }
    
    public int tamano()
    {
        int tam;
        
        tam = array.length;
        
        return tam;
    }
    
    public void insertar(int pos, int elemento)
    {
        array[pos] = elemento;
    }
    
    public int extraer(int pos)
    {
        int elemento;
        
        elemento = array[pos];
        
        return elemento;
    }
    
}