
/*
The Java Reflection API is used to manipulate classes and everything in a
class including fields, methods, constructors, private data, etc.

Because using the Reflection API is most often Dynamic it can slow down a
program because the JVM can't optimize the code.

The Reflection API can't be used with applets because of the added security
applets require.

Because this API allows you to do things like access private fields, methods,
etc. it should be used sparingly, else potentially destroy the logic of program
*/

package a_functional;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import b_objectoriented.ObjectClass;

public class L_Reflection {
    public static void main(String[] args) 
            throws ClassNotFoundException, 
            IllegalAccessException, InstantiationException {

        System.out.println();
        System.out.println("class");
        System.out.println();

        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< class >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        // get the class object, everything has a class object
        Class reflectClass = ObjectClass.class;

        // get the class name of an class
        String className = reflectClass.getName();
        System.out.println("class name " + className);

        /*
        Check modifiers of a class
        isAbstract, isFinal, isInterface, isPrivate, isProtected,
        isStatic, isStrict, isSynchronized, isVolatile,..
        */
        int classModifiers = reflectClass.getModifiers();
        System.out.println("is it public " + Modifier.isPublic(classModifiers));

        // You can get a list of interfaces used by a class
        Class[] interfaces = reflectClass.getInterfaces();
        for(int i=0; i<interfaces.length; i++){
            System.out.println("interface is " + interfaces[i]);
        }
        
        // Get the super class for specified class
        Class classSuper = reflectClass.getSuperclass();
        System.out.println("superclass is " + classSuper.getName());

        System.out.println();
        System.out.println("methods");
        System.out.println();

        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< methods >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        // Get the objects methods, return type and parameter type
        Method[] classMethods = reflectClass.getDeclaredMethods();
        for (Method method : classMethods) {

            // get the method name
            System.out.println("Method Name: " + method.getName());

            // check if a method is a getter or setter
            if (method.getName().startsWith("get")) {
                System.out.println("Getter Method");
            } else if (method.getName().startsWith("set")) {
                System.out.println("Setter Method");
            }

            // get the methods return type
            System.out.println("Return Type: " + method.getReturnType());

            // get parameter types
            Class[] parameterType = method.getParameterTypes();
            for (Class parameter : parameterType) {
                /*
                parameter.getName also returns it's type
                there is also method parameter.getTypeName()
                */
                System.out.println("parameter type " + parameter.getName());
            }
            
            System.out.println();
        }

        System.out.println();
        System.out.println("constructors");
        System.out.println();

        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< constructors >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        // To return an array of constructors instead do this
        Constructor[] constructors = reflectClass.getConstructors();
        for(Constructor constructor : constructors){
            Class[] constructParameters = constructor.getParameterTypes();
            for (Class parameter : constructParameters) {
                /*
                parameter.getName() returns it's type
                there is also method parameter.getTypeName()
                */
                System.out.println("parameter name " + parameter.getName());
                System.out.println("parameter type " + parameter.getTypeName());
                System.out.println();
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("fields");
        System.out.println();

        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< fields >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        Field[] allFields2 = reflectClass.getDeclaredFields();
        for (Field field : allFields2) {
            System.out.println("field name " + field.getName());
            System.out.println("field type " + field.getType());
            System.out.println();
        }
    }
}
