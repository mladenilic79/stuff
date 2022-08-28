
package e_web;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ServerServerUdp {
    public static void main(String[] args) {
        
        try {
            // define type for receive & send message
            byte[] sentData = new byte[1024];
            sentData = "perovic".getBytes();
            byte[] receiveData = new byte[1024];
            
            // start server
            DatagramSocket server = new DatagramSocket(5050);
            
            // declare receive packet
            DatagramPacket receivePacket 
                    = new DatagramPacket(receiveData, receiveData.length);
            System.out.println("server is listening...");
            
            // declare send data
            DatagramPacket sentPacket 
                    = new DatagramPacket(sentData, sentData.length);
            
            while(true){
                // receive message
                server.receive(receivePacket);
                String Message = new String(receivePacket.getData());
                
                // send message
                server.send(sentPacket);
            }
            
        } catch (SocketException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
