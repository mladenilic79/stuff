
package b_objectoriented;

public class ComparableClass implements Comparable<ComparableClass> {

    private int index;
    private String ime;
    private String prezime;

    public ComparableClass(){ 
    }
    public ComparableClass(int index, String ime, String prezime) {
        this.index = index;
        this.ime = ime;
        this.prezime = prezime;
    }
    
    public int getIndex() {
        return index;}
    public void setIndex(int index) {
        this.index = index;}
    public String getIme() {
        return ime;}
    public void setIme(String ime) {
        this.ime = ime;}
    public String getPrezime() {
        return prezime;}
    public void setPrezime(String prezime) {
        this.prezime = prezime;}

    @Override
    public String toString() {
        return "Student{" + "index=" + index 
                + ", ime=" + ime + ", prezime=" + prezime + '}';
    }

    // comparable is comparing itself with another object
    @Override
    public int compareTo(ComparableClass o) {
        // in case of comparing strings
        return this.prezime.compareTo(o.prezime);
        // in case of comparing integers
//        return this.index-o.index;    }
    }
}
