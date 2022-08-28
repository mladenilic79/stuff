package c_perzistencija;

import java.io.Serializable;

// serializable makes object able to be saved
public class ACovek implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String jmbg;
    private String ime;
    // transient attribute (prezime se ne cuva trajno)
    private transient String prezime;

    public ACovek() {
    }

    public ACovek(String jmbg, String ime, String prezime) {
        this.jmbg = jmbg;
        this.ime = ime;
        this.prezime = prezime;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    @Override
    public String toString() {
        return "Covek{" + "jmbg=" + jmbg + ", ime=" + ime + ", prezime=" + prezime + '}';
    }

}
