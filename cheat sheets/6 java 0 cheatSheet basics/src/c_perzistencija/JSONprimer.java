
package c_perzistencija;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSONprimer {
    
    private static void upisiJSON(ACovek covek) throws IOException {
        JSONObject json = new JSONObject();
        json.put("jmbg", covek.getJmbg());
        json.put("ime", covek.getIme());
        json.put("prezime", covek.getPrezime());
        FileWriter writer = new FileWriter("covek.json");
        writer.write(json.toJSONString());
        writer.close();
    }
    
    private static ACovek procitajJSON() throws Exception {
        JSONParser parser = new JSONParser();
        JSONObject procitaniObjekat 
                = (JSONObject) parser.parse(new FileReader("covek.json"));
        
        String jmbg = procitaniObjekat.get("jmbg").toString();
        String ime = procitaniObjekat.get("ime").toString();
        String prezime = procitaniObjekat.get("prezime").toString();
        
        return new ACovek(jmbg, ime, prezime);
    }
    
    public static void main(String[] args) throws IOException, Exception {
        
        ACovek covek = new ACovek("3333", "laza", "lazic");
        upisiJSON(covek);

//        ACovek procitaniCovek = procitajJSON();
//        System.out.println(procitaniCovek);
        
        System.out.println("executed");
    }
}
