
package c_perzistencija;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SerijalizacijaPrimer {
    
    public static void upisiUDatoteku(List<ACovek> ljudi) throws Exception {
        // version 1
        FileOutputStream fos = new FileOutputStream("covek.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        // version 2 (alternatively on one line)
        ObjectOutputStream oos2 
                = new ObjectOutputStream(new FileOutputStream("covek.dat"));
        // writing object
        oos.writeObject(ljudi);
        oos.close();
    }
    
    public static List<ACovek> procitajLjude() throws Exception {
        // version 1
        FileInputStream fis = new FileInputStream("covek.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);
        // version 2 (alternatively on one line)
        ObjectInputStream ois2 
                = new ObjectInputStream(new FileInputStream("covek.dat"));
        // reading objects
        List<ACovek> ljudi = (List<ACovek>)ois.readObject();
        ois.close();
        return ljudi;
    }
    
    public static void main(String[] args) throws Exception {
        
        ACovek c1 = new ACovek("1111", "Steva", "Stevic");
        ACovek c2 = new ACovek("2222", "Mika", "Mikic");
        List<ACovek> ljudi = new ArrayList<>();
        ljudi.add(c1);
        ljudi.add(c2);
        upisiUDatoteku(ljudi);

//        List<ACovek> procitaniLjudi = procitajLjude();
//        for (ACovek c : procitaniLjudi) {
//            System.out.println("procitan: " + c);
//        }
        
        System.out.println("executed");
    }
}

