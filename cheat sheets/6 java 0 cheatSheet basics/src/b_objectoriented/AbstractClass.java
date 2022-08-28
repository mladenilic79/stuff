package b_objectoriented;

/*
Create abstract class & methods with abstract keyword
Abstact class cannot be made an instance (object)
 */

public abstract class AbstractClass {

    int AbsClassVar1;
    int AbsClassVar2 = 0;

    // regular method
    void abstractImplementedMethod() {
        System.out.println("obican method");
    }

    // abstract method
    abstract void abstractUnimplementedMethod();
}
