package sockettcpclient;

public class SocketTCPClient {

    public static void main(String[] args) {
        String[] nombreyP = new String[2];
        nombreyP[0] = "ubuntu";
        nombreyP[1] = "5000";
        System.out.println("Soy el cliente"); 
        connectionC otro = new connectionC();
        otro.connectionC(nombreyP);
    }
}
