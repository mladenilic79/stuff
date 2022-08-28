
package b_objectoriented;

public class ObjectClass extends AbstractClass implements InterfaceClass{
    
    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
    // <<<<< variables >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
    
    // class object counter
    static int randomVar1 = 0;
    
    int var1;
    ObjectClass2 obj2; // composition

    private int var2;
    private String var3;
    
    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
    // <<<<< constructors >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
    
    /*
    The Constructor method name is the same as the class
    The constructor can't return value (no reason to put any type inside of one)
    You can overload constructors like any other method (constructor chain)
    calling setter in constructor possible but not recomended
    default/empty Constructor is provided if you don't create any other
    */
    
    public ObjectClass() {
        // class object counter
        randomVar1++;
    }
    public ObjectClass(int var2, String variable3) {
        /*
        use this keyword to call other constructors (must be on first line)
        calling constructor with no arguments
        */
        this();
        this.var2 = var2; // moze sa this.
        var3 = variable3; // moze i bez this. ako su nazivi razliciti
    }
    public ObjectClass(int var1, int var2, String var3) {
        // calling constructor with two arguments
        this(var2, var3);
        this.var1 = var1;
    }
    // passing object of another class as a parameter
    public ObjectClass(int var1, ObjectClass2 obj2){
        this.var1 = var1;
        this.obj2 = obj2;
    }
    
    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
    // <<<<< accessors >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
    
    // setter with checked exception
    public void setVar2(int var2) throws ExceptionCustom{
        if(var2<0) throw new ExceptionCustom();
        this.var2 = var2;
        System.out.println("setted " + var2);
    }
    // setter regular
    public void setVar3(String var3){
        this.var3 = var3;
        System.out.println("setted " + var3);
    }
    // getters regular
    public double getVar2(){
        System.out.println("gets " + var2);
        return var2;
    }
    public String getVar3(){
        System.out.println("gets " + var3);
        return var3;
    }
    
    // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
    // <<<<< methods >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
    
    void ObjectClassMethod(){
        System.out.println("ObjectClass Method");
    }
    
    @Override
    void abstractUnimplementedMethod(){
        System.out.println("ObjectClass overrided abstactUnimplementedMethod");
    }
    @Override
    void abstractImplementedMethod(){
        System.out.println("ObjectClass overrided abstactImplementedMethod");
    }
    
    @Override
    public void interfaceMethod() {
        System.out.println("ObjectClass overrided interfaceMethod");
    }

    @Override
    public String toString() {
        return "ObjectClass{" + "var1=" + var1 
                + ", var2=" + var2 + ", var3=" + var3 + '}';
    }
}
