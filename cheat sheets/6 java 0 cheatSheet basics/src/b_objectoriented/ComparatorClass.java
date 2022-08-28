
package b_objectoriented;

import java.util.Comparator;

public class ComparatorClass implements Comparator<ComparableClass>{

    // comparator is external to the object comparing
    @Override
    public int compare(ComparableClass o1, ComparableClass o2) {
        return o1.getIndex() - o2.getIndex();
        // or
//        return o1.getIme().compareTo(o2.getIme());
        // or
//        if (o1.getIndex() < o2.getIndex()) return -1; 
//        if (o1.getIndex() > o2.getIndex()) return 1; 
//        else return 0; 
    }
}
