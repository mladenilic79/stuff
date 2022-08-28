
package a_functional;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeSet;
import java.util.Vector;

public class H_collections {
    
    public static void main(String[] args) {
        
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< basics & variables >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        /*
        collections (receives any and all complex types)
        HashMap<student, HashSet<predmet>> mapa = new HashMap<>();
        */

        // makes an array & converts to list
        Integer[] xarray = { 3, 2, 5, 1, 8, 4, 88, 32, 11, 23 };
        List<Integer> larray = Arrays.asList(xarray);
        // or from java 9 & above
        List<Integer> larray2 = List.of(xarray);
        
        // constructors
        ArrayList<Integer> al = new ArrayList<>(larray);
        LinkedList<Integer> ll = new LinkedList<>(larray);
        Vector<Integer> v = new Vector<>();
        Stack<Integer> s = new Stack<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(larray);
        ArrayDeque<Integer> ad = new ArrayDeque<>(larray);
        HashSet<Integer> hs = new HashSet<>(larray);
        LinkedHashSet<Integer> lhs = new LinkedHashSet<>(larray);
        TreeSet<Integer> ts = new TreeSet<>(larray);

        // alternative constructor for customized use, for all collections
        List<Integer> l = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        Collection<Integer> c = new ArrayList<>();
        
        /*
        collection will accept raw inputs (object type) but will require
        subsequently casting of type
        */
        ArrayList altAl = new ArrayList();
        List altL = new ArrayList();
        Collection altC = new ArrayList();
        
        // put same type collection for copying
        ArrayList alCopy = new ArrayList(al);
        
        // combination commands
        al.subList(3, 4).clear(); // clear part of a list
        
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< collections class >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        // add element or elements to collection
        Collections.addAll(al, xarray);
        Collections.addAll(al, 3, 5, 9);
        
        /*
        <lists only>
        copy all elements from one list to another
        destination must be at least the same size as source
        */
        Collections.copy(al, ll);
        
        // replaces all elements of list with the specified element
        Collections.fill(al, 7);
        
        /*
        <lists only>
        sort for string & wrappers
        */
        Collections.sort(al);
        Collections.sort(al, Collections.reverseOrder());
        
        /*
        <lists only>
        reverses the order of elements
        */
        Collections.reverse(al);
        
        /*
        <lists only>
        randomly shuffles the elements
        */
        Collections.shuffle(al);
        
        /*
        <lists only>
        searches for the object using binary search algorithm, returns index
        there is also method with custom comparator
        */
        Collections.binarySearch(al, 3);
        
        // frequency of element in collection, returns integer
        Collections.frequency(al, 7);
        
        // check if two collections have elements in common, returns boolean
        Collections.disjoint(al, ts);
        
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< collection interface (extends iterable) >>>>> @@@@@@@@@@@@@@@@@
        
        // it is used to insert an element in this collection
        al.add(5); // add to end
        al.add(1, 6); // add to index 1
        
        // insert one collection to another
        al.addAll(ll);
        
        // delete an element from the collection (receives element or index)
        al.remove(5);
        // in case of list of integers
        al.remove((int)7); // removing at index
        al.remove((Integer)11); // removing value
        
        /*
	public boolean removeAll(Collection<?> c)
            It is used to delete all the elements of the specified collection
	default boolean removeIf(Predicate<? super E> filter)
            It is used to delete all the elements of the collection that satisfy
            the specified predicate.
	public boolean retainAll(Collection<?> c)
            It is used to delete all the elements of invoking collection except
            the specified collection.
        */
        
        // it returns the total number of elements in the collection
        al.size();
        
        // it removes all elements
        // al.clear();
        
        // search for an element, returns boolean
        al.contains(5);

        // search the specified collection in the collection
        al.containsAll(ts);
        
        /*
	public Iterator iterator()
            It returns an iterator.
        */
        
        // it converts collection into array of type object
        Object[] object = al.toArray();
        // from java 11 also
        Object[] array2 = altAl.toArray(Object[]::new);
        
        /*
	public <T> T[] toArray(T[] a)
            It converts collection into array.
        */
        
        // checks if collection is empty, returns boolean
        al.isEmpty();
        
        /*
	default Stream parallelStream()
            returns a possibly parallel Stream with the collection as its source
	default Stream stream()
            It returns a sequential Stream with the collection as its source
	default Spliterator spliterator()
            It generates a Spliterator over the specified elements in collection
	public boolean equals(Object element)
            It matches two collections
	public int hashCode()
            It returns the hash code number of the collection
        */

        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< iterator interface >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        /*
        public boolean hasNext()
            It returns true if the iterator has more elements else returns false
	public Object next()
            It returns the element and moves the cursor pointer to next element
	public void remove()
            It removes the last elements returned by the iterator, less used
        */
        
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< iterable interface >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        /*
        Iterator<T> iterator()
            it returns the iterator over the elements of type T
        */

        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< list interface (extends collection) >>>>> @@@@@@@@@@@@@@@@@@@@@
        // list interface is implemented by the classes ArrayList & LinkedList 
        // (Vector & Stack are obsolete)

        // Returns the object stored at the specified index
        al.get(0);
        
        // returns index of a first/last occurence of the object
        al.indexOf(2);
        al.lastIndexOf(3);
        
        // sublist extract from index (inclusive) to index (exclusive)
        al.subList(3, 6);
        
        /*
        replaces the element at index with the element
        returns element previously stored at that index
        (index, element)
        */
        al.set(3, 2);
        
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< array list class (implements list) >>>>> @@@@@@@@@@@@@@@@@@@@@@
        
        // constructor empty (default size is 10)
        ArrayList<Integer> al1 = new ArrayList<>();
        // constructor size
        ArrayList<Integer> al2 = new ArrayList<>(50);
        // constructor collecition (any collection)
        ArrayList<Integer> al3 = new ArrayList<>(ts);
        
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< linked list class (implements list, queue & deque) >>>>> @@@@@@
        
        // constructor empty
        LinkedList<Integer> ll1 = new LinkedList<>();
        // constructor collection (any collection)
        LinkedList<Integer> ll2 = new LinkedList<>(ts);
        
        // retrieve first/last object
        ll.getFirst();
        ll.getLast();

        // places object first/last
        ll.addFirst(9);
        ll.addLast(7);
        
        // delete & return object
        ll.removeFirst();
        ll.removeLast();
        
        /*
        remove the first occurrence of element (when traversing from head to
        tail) returns boolean
        */
        ll.removeFirstOccurrence(9);
        
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< vector class (implements list) >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@
        
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< stack class (extends vector, implements list) >>>>> @@@@@@@@@@@
        
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< queue interface (extends collection) >>>>> @@@@@@@@@@@@@@@@@@@@
        // queue interface implemented by PriorityQueue, ArrayDeque & LinkedList

        // retrives the first element and deletes it from the queue
        ll.poll();
        
        // retrieves the first element
        ll.peek();
        
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< priority queue class (implements queue) >>>>> @@@@@@@@@@@@@@@@@
        
        // empty constructor
        PriorityQueue pq1 = new PriorityQueue();
        // constructor size
        PriorityQueue pq2 = new PriorityQueue(10);
        // constructor collection
        PriorityQueue pq3 = new PriorityQueue(ts);
        
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< deque interface (extends collection & queue) >>>>> @@@@@@@@@@@@
        // deque interface is implemented by classes ArrayDeque & LinkedList

        // retrives & removes from the queue
        ll.pollFirst();
        ll.pollLast();
        
        // push puts & pop removes element on the front of the list
        ll.push(9);
        ll.pop();

        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< array deque class (implements deque & queue) >>>>> @@@@@@@@@@@@
        
        // empty constructor
        ArrayDeque ad1 = new ArrayDeque();
        // constructor size
        ArrayDeque ad2 = new ArrayDeque(10);
        // constructor collection
        ArrayDeque ad3 = new ArrayDeque(ts);
        
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< set interface (extends collection) >>>>> @@@@@@@@@@@@@@@@@@@@@@
        // set interface is implemented by HashSet, LinkedHashSet & TreeSet

        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< hash set class (implements set) >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@
        
        // empty constructor
        HashSet hs1 = new HashSet();
        // constructor size
        HashSet hs2 = new HashSet(10);
        // constructor collection
        HashSet hs3 = new HashSet(ts);
        
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< linked hash set class (implements set) >>>>> @@@@@@@@@@@@@@@@@@
        
        // empty constructor
        LinkedHashSet lhs1 = new LinkedHashSet();
        // constructor size
        LinkedHashSet lhs2 = new LinkedHashSet(10);
        // constructor collection
        LinkedHashSet lhs3 = new LinkedHashSet(ts);
        
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< sorted set interface (extends set & collection)) >>>>> @@@@@@@@
        // sorted set interface is implemented by class TreeSet
        
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< navigable set interface
        // (extends set, sorted set & collection) >>>>> @@@@@@@@@@@@@@@@@@@@@@@@
        // sorted set interface is implemented by class TreeSet
        
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< tree set class
        // (implemens set, sorted set & navigable set) >>>>> @@@@@@@@@@@@@@@@@@@
        
        // empty constructor
        TreeSet ts1 = new TreeSet();
        // constructor collection
        TreeSet ts2 = new TreeSet(al);
        
        System.out.println("executed");
    }
}
