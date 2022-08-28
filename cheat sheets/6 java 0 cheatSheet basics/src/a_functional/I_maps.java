
package a_functional;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class I_maps {
    
    public static void main(String[] args) {
        
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< basics & variables >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        /*
        collections (receives any and all complex types)
        HashMap<student, HashSet<predmet>> mapa = new HashMap<>();
        */
        
        // constructors
        HashMap<Integer, String> hm = new HashMap<>();
        hm.put(1, "ana");
        hm.put(2, "pera");
        hm.put(3, "zika");
        LinkedHashMap<Integer, String> lhm = new LinkedHashMap<>(hm);
        Hashtable<Integer, String> ht = new Hashtable<>(hm);
        TreeMap<Integer, String> tm = new TreeMap<>(hm);
        
        // inline initialization java 9
        Map<Integer,String> map = Map.of(1, "A", 2, "B", 3, "C");
        
        // combination commands
        hm.keySet().contains(6);
        
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< map interface >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        // add key/value pairs (will override existing keys)
        hm.put(1, "ana");
        // if not already specified
        hm.putIfAbsent(2, "perovic");
        
        /*
        replaces the specified value for a specified key
        will not add key if nonexistant
        */
        hm.replace(7, "saka");
        /*
        replaces the old value with the new value for a specified key
        will execute only if key & value exists
        (key, old value, new value)
        */
        hm.replace(3, "saka", "mebla");
        
        // remove specified key
        hm.remove(1);
        
        // clear map from all keys
//        hm.clear();
        
        // returns value based on key
        hm.get(2);
        // or default value
        hm.getOrDefault(5, "default value");
        
        // check if map is empty, returns boolean
        hm.isEmpty();

        // returns size
        hm.size();
        
        // check is key exists, returns boolean
        hm.containsKey(9);
        
        // check if value exists, returns boolean
        hm.containsValue("ana");
        
        // returns collection of values
        hm.values();

        // returns set of the keys
        hm.keySet();

        /*
        returns set of key/value pairs, of type Map.Entry
        used for iterating
        */
        hm.entrySet();
        
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< map.entry interface (extends map interface) >>>>> @@@@@@@@@@@@@
        
        // for iterating
        for(Map.Entry<Integer, String> entry : hm.entrySet()){
            int i = entry.getKey();
            String j = entry.getValue();
        }
        
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< hash map (implements map & map.entry interface) >>>>> @@@@@@@@@
        
        // empty constructor
        HashMap<Integer, String> hm1 = new HashMap();
        // size constructor
        HashMap<Integer, String> hm2 = new HashMap(10);
        // map constructor
        HashMap<Integer, String> hm3 = new HashMap(hm);
        
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< linked hash map (extends hash map class)
        // (implements map & map.entry interface) >>>>> @@@@@@@@@@@@@@@@@@@@@@@@
        
        // empty constructor
        LinkedHashMap<Integer, String> lhm1 = new LinkedHashMap<>();
        // size constructor
        LinkedHashMap<Integer, String> lhm2 = new LinkedHashMap<>(10);
        // map constructor
        LinkedHashMap<Integer, String> lhm3 = new LinkedHashMap<>(hm);
        
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< hashtable (implements map & map.entry interface)
        // (obsolete) >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< sorted map interface (extends map interface) >>>>> @@@@@@@@@@@@
        
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< navigable map interface (extends sorted map interface) >>>>> @@
        
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< tree map class
        // (implements map & sorted map & navigable map interface) >>>>> @@@@@@@
        
        // empty constructor
        TreeMap<Integer, String> tm1 = new TreeMap<>();
        TreeMap<Integer, String> tm3 = new TreeMap<>(hm);
        
        System.out.println("executed");
    }
}
