
package e_web;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ServerClient {
    public static void main(String[] args) throws IOException {
        
        Socket server = new Socket("localhost", 5050);
        
        // writing
        OutputStream os = server.getOutputStream();
        OutputStreamWriter osw = new OutputStreamWriter(os);
        BufferedWriter bw = new BufferedWriter(osw);
        
        bw.write("perovic");
        osw.write("perovic");
        os.write("perovic".getBytes());
        
        // reading
        InputStream is = server.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        
        // varijanta 1
//        while(true){
//        String line = br.readLine();
//        if(line.isEmpty())
//            break;
//        System.out.println("klijent je poslao: " + line);
//        }

        // varijanta 2
        String line = "";
        while(!(line=br.readLine()).isEmpty()){
            System.out.println(line); 
        }
        
        os.flush();
        osw.flush();
        bw.flush();
        is.close();
        isr.close();
        br.close();
        os.close();
        osw.close();
        bw.close();
        server.close();
    }
}
