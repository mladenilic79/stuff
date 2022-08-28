
package c_perzistencija;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TekstualnaDatotekaPrimer {
    
    // random example for io
    
    private static void upisiUDatoteku(ACovek covek) throws Exception{
        
        PrintWriter out = new PrintWriter(new FileWriter("covek.txt", true));
        out.println(covek.getJmbg()+";"+covek.getIme()+";"+covek.getPrezime());
        out.close();
    }
    
    private static List<ACovek> ucitajIzDatoteke() throws Exception{
        
        BufferedReader reader = new BufferedReader(new FileReader("Covek.txt"));
        
        List<ACovek> rez = new ArrayList<>();
        
        String red = "";
        
        while ((red = reader.readLine()) !=null){
            
            StringTokenizer st = new StringTokenizer(red, ";");
            
            while(st.hasMoreTokens()){
                
                String jmbg = st.nextToken();
                String ime = st.nextToken();
                String prezime = st.nextToken();
                
                ACovek noviCovek = new ACovek(jmbg, ime, prezime);
                
                rez.add(noviCovek);
            }
        }
        return rez;
    }
    
    public static void main(String[] args) throws Exception {
        ACovek c1 = new ACovek("1111", "pera", "peric");
        ACovek c2 = new ACovek("2222", "mika", "mikic");
        ACovek c3 = new ACovek("3333", "laza", "lazic");
        
        // writing
        upisiUDatoteku(c1);
        upisiUDatoteku(c2);
        upisiUDatoteku(c3);

        // reading
//        List<ACovek> ljudi = ucitajIzDatoteke();
//        for (ACovek c : ljudi) {
//            System.out.println("procitan: " + c);
//        }
        
        System.out.println("executed");
    }
}
