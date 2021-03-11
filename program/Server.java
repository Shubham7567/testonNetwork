package testonNetwork;

import java.net.*;
import java.nio.charset.StandardCharsets;

public class Server {
    public static void main(String[] args)
    {
        try{
            DatagramSocket serverSocket = new DatagramSocket(9876);
            byte[] recieveData = new byte[1024];
            String clientSentance = "";
            while(!clientSentance.equals("bye") && !clientSentance.equals("exit"))
            {
                DatagramPacket recievePackate = new DatagramPacket(recieveData, recieveData.length);
                serverSocket.receive(recievePackate);
                clientSentance = new String(recievePackate.getData(),StandardCharsets.UTF_8).trim();
                recieveData = new byte[1024];
                System.out.println("Data from Client : "+clientSentance);
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
