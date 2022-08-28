package c_perzistencija;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MySqlPrimer {

    private static List<ACovek> vratiSveLjude() {

        // localhost is equivelent to 127.0.0.1
        try {
            Connection conn 
                    = DriverManager.getConnection(
                            "jdbc:mysql://127.0.0.1:3306/test02",
                            "root", "root");
            Statement stmt = conn.createStatement();
            stmt.executeQuery("select * from covek");
            ResultSet rs = stmt.getResultSet();
            // alternatively in one line
//            ResultSet rs = stmt.executeQuery("select * from covek");

            List<ACovek> ljudi = new ArrayList<>();

            while (rs.next()) {
                String jmbg = rs.getString("jmbg");
                String ime = rs.getString("ime");
                String prezime = rs.getString("prezime");
                ACovek ljudiTemp = new ACovek(jmbg, ime, prezime);
                ljudi.add(ljudiTemp);
            }
            conn.close();
            return ljudi;
        } catch (SQLException se) {
            System.out.println("greska pri konekciji");
            return null;
        }
    }

    private static void dodajCoveka(ACovek noviCovek) {
        try {
            Connection conn 
                    = DriverManager.getConnection(
                            "jdbc:mysql://127.0.0.1:3306/test02",
                            "root", "root");
            Statement stmt = conn.createStatement();
            String query 
                    = "insert into covek (`jmbg`, `ime`, `prezime`)"
                    + " values ('" + noviCovek.getJmbg() + "','"
                    + noviCovek.getIme() + "','" 
                    + noviCovek.getPrezime() + "')";

            System.out.println(query);

            stmt.execute(query);
            conn.close();
        } catch (SQLException se) {
            System.out.println("greska pri konekciji");
        }
    }

    public static void main(String[] args) {

        ACovek noviCovek 
                = new ACovek("1234123412344", "novo ime", "novo prezime");
        dodajCoveka(noviCovek);
        
//        List<ACovek> ljudi = vratiSveLjude();
//        for (ACovek c : ljudi) {
//            System.out.println(c);
//        }
    }
}
