
package a_functional;

public class M_annotations {
    
    public static void main(String[] args) {
        
        /*
        Built-In Java Annotations used in java code
            @Override
            @SuppressWarnings("unchecked")
                @SuppressWarnings(value = "unchecked")
                @SuppressWarnings({"checked", "deprecation"}) 
                @SuppressWarnings("all")
            @Deprecated
        
        Built-In Java Annotations used in other annotations
        
            @Target(ElementType.TYPE)
                    Element Types-------Where the annotation can be applied
                    TYPE----------------class, interface or enumeration
                    FIELD---------------fields
                    METHOD--------------methods
                    CONSTRUCTOR---------constructors
                    LOCAL_VARIABLE------local variables
                    ANNOTATION_TYPE-----annotation type
                    PARAMETER-----------parameter
        
            @Retention
                RetentionPolicy.SOURCE      refers to the source code, discarded
                    during compilation. It will not be available in the compiled class.
                RetentionPolicy.CLASS       refers to the .class file, available
                    to java compiler but not to JVM . It is included in the class file.
                RetentionPolicy.RUNTIME     refers to the runtime, available to
                    java compiler and JVM .
        
            @Inherited  //  By default, annotations are not inherited to subclasses
                            @Inherited annotation marks the annotation to be inherited to subclasses

            @Documented  // Marks the annotation for inclusion in the documentation
        
        defining custom annotations (build them same sa you make new class)

            @Documented
            @Inherited
            @Target(ElementType.TYPE)
            // or multiple types
            @Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
            @Retention(RetentionPolicy.RUNTIME)
            // define annotation with interface than name
            @interface TestAnnotation
            {
                // default values can be left out on call
                String Developer() default "Rahul";
                int value1();
                String value2();
                // add array of values
                String[] newNames();
            }
        
        applying/calling custom annotations
        
            // can left out all elements that have default value
            @MyAnnotation(value1=10, value2="Arun Kumar", newNames={"Jenkov", "Peterson"})
            // or in case where all si defined
            @MyAnnotation
        */
        
    }
    
}
