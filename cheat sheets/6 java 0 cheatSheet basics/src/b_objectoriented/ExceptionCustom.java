
package b_objectoriented;

public class ExceptionCustom extends Exception {
    
    @Override
    public String toString() {
        return "toString() exception message";
    }
    
    @Override
    public String getMessage() {
        return "getMessage() exception message";
    }
}
