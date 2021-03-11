package testonNetwork;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets; 

public class Client {
    public static void main(String[] args)
    {
        try{
            BufferedReader inFromUSer = new BufferedReader(new InputStreamReader(System.in));
            DatagramSocket clientSocket = new DatagramSocket();
            byte[] recieveData = new byte[1024];
            byte[] sendData = new byte[1024];
            String clientSentance = "";
            while(!clientSentance.equals("bye") && !clientSentance.equals("exit"))
            {
                clientSentance = inFromUSer.readLine();
                InetAddress Address = InetAddress.getLocalHost();
                sendData = clientSentance.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,Address,9876);
                clientSocket.send(sendPacket);
            }
        }catch(Exception ex)
        {
            ex.printStackTrace(System.err);
        }
    }
}
