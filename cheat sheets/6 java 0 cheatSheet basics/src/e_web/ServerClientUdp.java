
package e_web;

import java.net.*;

class UDPClient {

    public static void main(String args[]) throws Exception {
        
        // define type for send & receive messages
        byte[] sendData = new byte[1024];
        sendData = "perovic".getBytes();
        byte[] receiveData = new byte[1024];

        // start client
        DatagramSocket client = new DatagramSocket();
        
        // send message
        InetAddress IPAddress = InetAddress.getByName("localhost");
        DatagramPacket sendPacket 
                = new DatagramPacket(
                        sendData, sendData.length, IPAddress, 9876);
        client.send(sendPacket);

        // receive message
        DatagramPacket receivePacket 
                = new DatagramPacket(receiveData, receiveData.length);
        client.receive(receivePacket);
        String modifiedSentence = new String(receivePacket.getData());

        // close client
        client.close();
    }
}
