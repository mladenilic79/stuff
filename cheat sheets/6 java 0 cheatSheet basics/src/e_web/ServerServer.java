
package e_web;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerServer {
    public static void main(String[] args) throws IOException {
        
        ServerSocket server = new ServerSocket(5050);
        System.out.println("server listening...");

        int requests = 0;

        while(true){
            Socket client = server.accept();
            System.out.println("connection accepted");

            // info methods
            System.out.println(
                    "remote address " + client.getRemoteSocketAddress());
            System.out.println("local address " + client.getLocalAddress());
            System.out.println("local port " + server.getLocalPort());
            System.out.println("local port " + client.getLocalPort());

            // reading
            InputStream is = client.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            // varijanta 1
//            while(true){
//            String line = br.readLine();
//            if(line.isEmpty())
//                break;
//            System.out.println("klijent je poslao: " + line);
//            }

            // varijanta 2
            String line = "";
            while(!(line=br.readLine()).isEmpty()){
                System.out.println(line); 
            }

            // writing
            OutputStream os = client.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);

            bw.write("pera");
            osw.write("HTTP/1.1 200 OK\r\n\r\n");
            os.write("HTTP/1.1 200 OK \r\n\r\n".getBytes());

            os.flush();
            osw.flush();
            bw.flush(); // this one should be
            is.close();
            isr.close();
            br.close();
            os.close();
            osw.close();
            bw.close();
            client.close(); // this one should be

            System.out.print(++requests+"\r");
        }
    }
}

