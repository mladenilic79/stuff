
package b_objectoriented;

import java.util.ArrayList;
import java.util.List;

/*
this
public <T extends Animal> void takeThing(ArrayList<T> list)
same as this
public void takeThing(ArrayList<? extends Animal> list)
use former.. more convinient for multiple parameters
*/

/*
extends limits posible usage of generic type
generic type can specialize during inheritance from parent
*/
// new class recognize generic types, T must be number, U can be any
public class GenericClass <T extends Number, U> extends GenericClassParent{
	// T extends Comparable<T>, means only types that extends comparable can be used
    
    private T x;
    private U y;
    public ArrayList<T> ArrayList1;

    public T getX() {
        return x;}
    public void setX(T x) {
        this.x = x;}
    public U getY() {
        return y;}
    public void setY(U y) {
        this.y = y;}

    public GenericClass(){
        System.out.println("GenericClass instance1");
    }
    public GenericClass(T x, U y) {
        this.x = x;
        this.y = y;
        System.out.println("GenericClass instance2");
    }
    public GenericClass(T x, U y, ArrayList<T> ArrayList1) {
        this.x = x;
        this.y = y;
        this.ArrayList1 = ArrayList1;
        System.out.println("GenericClass instance3");
    }

    // with generic return value also
    public <T> T GenericMethod(T[] randomArray){
        for (T randomVar2 : randomArray){
            System.out.print(randomVar2);
        }
        return randomArray[0];
    }
    
    /*
    Question mark (?) is the wildcard in generics and represent an unknown
    type. The wildcard can be used as the type of a parameter, field, or
    local variable and sometimes as a return type. We can’t use wildcards
    while invoking a generic method or instantiating a generic class.
    */
    public void genericParameter1(GenericClass<?,?> parameter) {
    }
    private void genericParameter2(List<? extends Number> list) {	
    }
}
