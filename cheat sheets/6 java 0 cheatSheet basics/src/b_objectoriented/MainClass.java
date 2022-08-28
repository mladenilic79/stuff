
/*
Every statement must end with a semicolon ;
White space has no meaning in Java
java is pass by value for basic types
java is pass by reference for complex types (arrays and objects)
*/

/**
for header javadoc files
*/

package b_objectoriented;

/*
To import an external class you use import
You can import whole libraries of classes like this import java.util.*;
*/
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

// avoid static imports, confusing to read
import static java.lang.Math.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

/*
You create subclasses with the extends keyword
inherit subclass has the Methods and Fields that class defined
*/
public class MainClass extends ObjectClass implements Runnable {

    // static initialization block, initialized on class load
    static{
        int xyz;
    } // same as (i guess)
    static int xyz;

    // MainClass variable
    int MainClassVar;
    
    ObjectClass obj1; // composition

    // constructors
    MainClass(){
    }
    MainClass(int MainClassVar, int var1, int var2, String variable3){
        // calling super constructor (cannot call both super & this)
    	// super();
        super(var1, var2, variable3);
        // add elements that don't exist in super class
        this.MainClassVar = MainClassVar;
        System.out.println("Main instance");
    }
    MainClass(ObjectClass obj1) {
		this.obj1 = obj1;
	}
    
	/*
    you can add new or override fields & methods in the subclass
    super. can be used for accessing, both variables & methods of super class
    */
    
    // main class method
    void MainClassMethod () {
        System.out.println("main class method");
    }

    // final will prevent changing of reference parameters inside method body
    void MainClassMethod2 (final ObjectClass oc) {
        System.out.println("main class method");
    }
    
    // overrided super class method (in this example not overrided)
    @Override
    void ObjectClassMethod() {
    	// super calls superclass
        super.ObjectClassMethod(); // override here
        // or
        // super.super.someClassMethod // for calling parent.parent.method
    }

    // toString() add super.toString() somewhere inside
    @Override
    public String toString() {
        return "MainClass{" + super.toString() 
                + "MainClassVar=" + MainClassVar + '}';
    }
    
    // overrided thread method
    @Override
    public void run() {
        System.out.println("i am running");
    }
    
    /*
    method with variable number of arguments
    parameters are received as an array
    calling with varArg(1,2,3,4,5);
    */
    void varArg(int ...numbers){
        for (int x : numbers){
            System.out.println(x);
        }
    }

    /*
    Every main function must accept an array of string objects for passing
    command line arguments with call: java randomClass.class arg[0] arg[1]
    */
    public static void main(String[] args) throws ExceptionCustom, IOException {
        
        // some variables
        double a = 18;
        double b = 45;
        String str1 = "1996-11-05";
        String str2 = "pera zdera";
        
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< exceptions >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        /*
        An exception object is created when an error occurs
        A checked exception is an exception the compiler forces you to
        protect against
        try/catch block must stand in method, cannot be alone

        java.lang.RuntimeException
            exceptions that can be thrown during the normal operation of the
            Java Virtual Machine. These exceptions are your responsibility as a
            programmer
        java.lang.Exception
            exceptions that are checked for by the java compiler
        ArithmeticException
            An arithmetic operation occurs with no answer
        ClassNotFoundException
            A class is called for that doesn't exist
        IllegalArgumentException
            A method has been passed an illegal argument
        IndexOutOfBoundsException
            Thrown when an index for an array, string is called for, but doesn't
            exist
        InputMismatchException
            (Part of NoSuchElementException) User enters the wrong data type
            into a Scanner method
        IOException
            An I/O operation failed

        To ignore an exception do this
        catch (ClassNotFoundException e)

        Java 7 allows you to catch multiple exceptions at once
        catch (FileNotFoundException | IOException e)

        If used finally is executed whether there was an exception or not,
        usually used for closing resources

        try with resource, close resource at the end without finally needed,
        objects that implements closable or autoclosable can be used here
        */
        
        // manual throw regular exception
        if(a<-5){
            throw new ArithmeticException();
        }
        
        // manual throw custom exception
        if(a<-5){
            throw new ExceptionCustom();
        }

        // try/catch block (list most specific exceptions first)
        try {
            System.out.println("resenje je: " + a/b);
        } catch(ArithmeticException e) {
            System.out.println("div with zero");
            e.printStackTrace();
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("greska");
            e.printStackTrace();
        } catch(Exception e) {
            System.out.println("gen");
            e.printStackTrace();
        } finally {
            System.out.println("fin");
        }

        /*
		try with resources (implements AutoClosable interface)
		exception handling mechanism that can automatically close resources 
		like a Java InputStream or a JDBC Connection when you are done with 
		them
		classic resource variant
        */
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("D:\\\\IT PROGRAMMING\\\\6 java 0 cheatSheet basics\\\\primer1.txt"));
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
        // try with resource variant (finally not needed)
        try (Scanner scanner2 = new Scanner(new File("D:\\IT PROGRAMMING\\6 java 0 cheatSheet basics\\primer1.txt"))) {
            while (scanner2.hasNext()) {
                System.out.println(scanner2.nextLine());
            }
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
        // with multiple resources (some outside the block)
        Scanner scanner3 = new Scanner(new File("D:\\IT PROGRAMMING\\6 java 0 cheatSheet basics\\primer1.txt"));
        try (scanner3; PrintWriter writer = new PrintWriter(new File("testWrite.txt"))) {
    	    while (scanner3.hasNext()) {
    	    	writer.print(scanner3.nextLine());
    	    }
        } catch (FileNotFoundException e) {
			e.printStackTrace();
		}
        
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< object oriented programming >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        /*
        classes
        classes are blueprints used to design objects that contain
        attributes (variables or fields) and methods (functions)

        names
        Class names should begin with a capital letter
        A file can't contain two public classes
        If class files are in same folder compiler will be able to find them

        static
        static means it belongs to all objects, not to the instance, applies to
        variables and methods, else they are local variables (part of a method)
        or instance variables (declared inside a instance)
        non static variables & methods can't be called from static method (main)

        final
        final applied to variables means it is a constant
        final applied to methods means it cannot be overwritten (constructor
        methods should be final)
        final applied to classes means in cannot be subclassed

        elements
        class can be public or without modifier
        class elements (including nested class) can be public, private, 
        protected or without modifier (package private)

        modifiers
        without modifier (package private) - visible from package
        public - visible everywhere
        private - visible from class (by elements that are inside same class)
        protected - visible from package & subclass of it's class in another
            package (This is a final method which means it can't be overwritten)

        accessing
        You retrieve class field values by listing the objectName.fieldName
        You execute class methods by listing objectName.methodName()
        */
        
        /*
        methods
        accessModifier static final returnDataType methodName (parameters)

        Return Data Type: The data type of value returned after a method
        executes (void if no values are returned)

        Method Name: Must start with a letter, but can include letters,
        numbers, $, or _ ... or main
        main is required in every Java program. This function is always
        executed first

        Parameters / Arguments: Values passed to a method (object instances
        including)

        When function doesn't return a value return type is void
        */

        // MainClass instance
        MainClass mc1 = new MainClass();
        MainClass mc2 = new MainClass(2, 4, 4, "pera");
        
        // MainClass methods
        System.out.println(mc1);
        System.out.println(mc1.toString());
        mc1.MainClassMethod();
        
        // MainClass Inherited Methods
        mc1.ObjectClassMethod();
        mc1.abstractImplementedMethod();
        mc1.abstractUnimplementedMethod();
        mc1.interfaceMethod();
        
        // MainClass variables
        mc1.MainClassVar = 3;
        
        // ObjectClass instances
        ObjectClass oc1 = new ObjectClass();
        ObjectClass oc2 = new ObjectClass(5, 2, "pera");
        
        // ObjectClass accessors
        oc1.setVar2(4);
        oc1.setVar3("pera");
        oc1.getVar2();
        oc1.getVar3();
        
        // ObjectClass methods
        System.out.println(oc1);
        System.out.println(oc1.toString());
        oc1.ObjectClassMethod();

        // ObjectClass Inherited Methods
        oc1.abstractImplementedMethod();
        oc1.abstractUnimplementedMethod();
        oc1.interfaceMethod();
        
        // ObjectClass variables
        oc1.var1 = 10;
        
        // composition access
        MainClass mc3 = new MainClass(oc1);
        mc3.obj1.ObjectClassMethod();
        
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< polymorphism >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        // example 1
        
        /*
        makes object of type objectClass, but
        makes object of class main (main class methods apply)
        */
        ObjectClass pm3 = new MainClass();
        
        // example 2
        
        // programming to an implementation
        // Dog d = new Dog();
        
        // programming to an interface
        // Animal animal = new Dog();

        /*
        This is Polymorphism.
        Left is higher ranked class or interface, right is implementation or
        concrete class (cannot be interface, must have constructor)
        The interpreter automatically figures out what type of Class it's
        dealing with
        If you want access to fields or methods only found in the SubClass you
        have to cast the object to that specific class first
        */
        
        /*
        interface type variable - If you define a variable whose type is an
        interface, any object you assign to it must be an instance of a class
        that implements the interface
        */
        
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< passing one instance/object to another >>>>> @@@@@@@@@@@@@@@@@@
        
        ObjectClass zaPojesti = new ObjectClass();
        ObjectClass2 halapljiv = new ObjectClass2();
        halapljiv.diggest(zaPojesti);
        
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< object class methods >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        // instanceof method (instance instanceof class)
        if(mc1 instanceof MainClass){
            System.out.println("jeste instanca");
        }
        
        // == compares primitives & reference address (returns true on equal)
        // equals compares content (returns true on equal content)
        
        // equals tells you if two objects are equal, returns boolean
        System.out.println(mc1.equals(mc2));
        // objects comparison returns positive only when it is the same element
        System.out.println(Objects.equals(str1, str2));
        // hashCode returns a unique identifier for an object
        System.out.println(mc1.hashCode());
        // getClass returns the class of the object (or just name)
        System.out.println(mc1.getClass());
        System.out.println(mc1.getClass().getName());
        // getSuperclass returns the super class of the class (or just name)
        System.out.println(mc1.getClass().getSuperclass());
        System.out.println(mc1.getClass().getSuperclass().getName());
        
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< nested classes >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        /*
        nested classes
        
        static nested class

        interacts with the instance members of its outer class (and other
        classes) just like any other top-level class. In effect, a static nested
        class is behaviorally a top-level class that has been nested in another
        top-level class for packaging convenience.
        Static nested classes are accessed using the enclosing class name:
        OuterClass.StaticNestedClass nestedObject =
                                           new OuterClass.StaticNestedClass();

        inner nested class

        instance of InnerClass can exist only within an instance of OuterClass
        and has direct access to that object's methods and fields. Also, because
        an inner class is associated with an instance, it cannot define any
        static members itself.
        To instantiate an inner class, first instantiate the outer class. Then,
        create the inner object within the outer object with this syntax:
        OuterClass.InnerClass innerObject = new OuterClass.InnerClass();
        */
        
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< generic classes >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        // ceneric class example, type can be casted or not
        GenericClass gc1 = new GenericClass(8.78, 3.22);
        GenericClass<Integer, String> gc2 = new GenericClass<>(3, "pera");
        
        /*
        generic method example
        (any array.. not needed to be specified in advance)
        */
        Integer[] irey = {2, 3, 5};
        Character[] crey = {'d', 'd', 'f'};
        gc1.GenericMethod(irey);
        gc1.GenericMethod(crey);
        
        // question mark (see GenericClass)
        List<? extends Object> strings = new ArrayList<String>();
        List<? extends Object> objects = new ArrayList<Object>();
        
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< comparable & comparator class >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        /*
        comparable compare itself with another object, whereas comparator is
        external & is comparing two different objects
        */
        
        /*
        comparing using default (natural order) comparable & comparator methods
        compare returns 0 if equal | -1 if bigDouble is less than bigInt | 1
        if bigDouble is greater than bigInt
        */
        System.out.println(Double.compare(a, b));
        System.out.println(str1.compareTo(str2));
        
        // comparing complex objects
        ArrayList<ComparableClass> CCValues = new ArrayList<>();
        ComparableClass s1 = new ComparableClass(4, "pera", "zdera");
        ComparableClass s2 = new ComparableClass(2, "mika", "bela");
        ComparableClass s3 = new ComparableClass(5, "seka", "persa");
        CCValues.add(s1);
        CCValues.add(s2);
        CCValues.add(s3);

        // comparable using overrided compareTo(object to be sorted) sort method
        Collections.sort(CCValues);
        
        /*
        comparator using comparator class instance & overrided method
        compare(object to be sorted, comparator class instance)
        */
        ComparatorClass cc = new ComparatorClass();
        Collections.sort(CCValues, cc);
        
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< threads >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        // thread sleep in miliseconds
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        
        // returns system time in milliseconds
        System.out.println(System.currentTimeMillis());
        
        // shuts down main thread
//        System.exit(0);
        
        // pass in Integer arraylist (into classes with thread interface)
        ArrayList<Integer> brojevii = new ArrayList<>();
        brojevii.add(8);
        brojevii.add(9);
        
        // runnable varijanta
        ThreadsRunnable nit3 = new ThreadsRunnable(brojevii);
        // or
//        Runnable nit3 = new ThreadsRunnable(brojevii);
        // version 1
        Thread nit33 = new Thread(nit3);
        nit33.start();
        // runnable varijanta petlja
        for (int j = 0; j < 5; j++) {
            // class declaration is optional??? not likely
            ThreadsRunnable nit4 = new ThreadsRunnable(brojevii);
            Thread nit44 = new Thread(nit4);
            nit44.start();
        }
        
        // extends varijanta
        ThreadsThread nit1 = new ThreadsThread(brojevii);
        // or
//        Thread nit1 = new ThreadsThread(brojevii);
        // version 1
        nit1.start();
        // extends varijanta petlja
        for(int j=0; j<5; j++){
            ThreadsThread nit2 = new ThreadsThread(brojevii);
            nit2.start();
        }
        
        // odradjen tread u mainu (overrided method run)
        Runnable nit5 = new Runnable() {
            @Override
            public void run() {
                // custom code inside
                System.out.println("nit5");
            }
        };
        // version 1
        Thread nit55 = new Thread(nit5);
        nit55.start();
        
        // thread u mainu sopstvene klase
        Thread nit6 = new Thread(mc1.toString());
        nit6.start();
        
        // thread with array
        Thread[] ThreadNiz = new Thread[5];
        // start threads through array
        for(int j=0; j<ThreadNiz.length; j++){
            ThreadNiz[j] = new ThreadsThread();
            ThreadNiz[j].start();   
        }
        // join threads through array
        for (int j=0; j<ThreadNiz.length; j++) {
            try {
                ThreadNiz[j].join();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        
        // runnable with array
        Thread[] RunnableNiz = new Thread[5];
        // start runnable through array
        for(int j=0; j<RunnableNiz.length; ++j){
            ThreadsRunnable nit7 = new ThreadsRunnable();
            RunnableNiz[j] = new Thread(nit7);
            RunnableNiz[j].start();
        }
        // join runnable through array
        for(int j=0; j<RunnableNiz.length; j++){
            try {
                RunnableNiz[j].join();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        
        // check if thread is alive
        nit1.isAlive();
        nit33.isAlive();
        nit55.isAlive();
        nit6.isAlive();
        ThreadNiz[1].isAlive();
        RunnableNiz[1].isAlive();
        
        // Thread.activeCount returns the number of threads running
        System.out.println("Number of Threads: " +Thread.activeCount());
        // create an array of threads with enough spaces for all active threads
        Thread[] listOfThreads = new Thread[Thread.activeCount()];
        // enumerate fills the Thread array with all active threads
        Thread.enumerate(listOfThreads);
        // Cycle through all the active threads and print out their names
        for(Thread p : listOfThreads){
            System.out.println(p.getName());
        }

        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< enumerate simple >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        // accessing directly
        EnumSimpleClass simpleVariable = EnumSimpleClass.ACTIVE;
        
        // looping
        for (EnumSimpleClass simpleVariable2 : EnumSimpleClass.values()) {
        	System.out.println(simpleVariable2);
        } 
        
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< enumerate object >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        // looping
        for(EnumObjectClass people: EnumObjectClass.values()){
        	// getting name of the objects & 
            System.out.printf(
                    "%s\t%s\t%s\n", people, people.getDesc(), people.getYear());
        }
        
        // looping but limited to range
        for(EnumObjectClass people: EnumSet.range(
                EnumObjectClass.bucky, EnumObjectClass.candy)){
            System.out.printf(
                    "%s\t%s\t%s\n", people, people.getDesc(), people.getYear());
        }
    }
}
