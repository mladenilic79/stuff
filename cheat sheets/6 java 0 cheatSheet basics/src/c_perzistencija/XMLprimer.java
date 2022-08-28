
package c_perzistencija;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class XMLprimer {
    
        private static void upisiUXML(ACovek covek) 
                throws FileNotFoundException {
            FileOutputStream fos = new FileOutputStream("covek.xml");
            XMLEncoder encoder = new XMLEncoder(fos);
            encoder.writeObject(covek);
            encoder.close();
        }
        
        private static ACovek procitajXML() throws FileNotFoundException  {
            FileInputStream fis = new FileInputStream("covek.xml");
            XMLDecoder decoder = new XMLDecoder(fis);
            ACovek procitaniCovek = (ACovek) decoder.readObject();
            decoder.close();
            return procitaniCovek;
        }
    
    public static void main(String[] args) throws Exception {
        
        ACovek covek = new ACovek("1234", "steva", "stevic");
        upisiUXML(covek);

//        ACovek procitaniCovek = procitajXML();
//        System.out.println("procitani covek: " + procitaniCovek);
        
        System.out.println("executed");
    }
}
