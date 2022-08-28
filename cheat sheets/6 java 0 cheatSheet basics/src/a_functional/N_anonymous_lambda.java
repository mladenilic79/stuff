package a_functional;

public class N_anonymous_lambda {

    /*
    (n) -> n*n

    The left side specifies the parameters required by the expression, which
    could also be empty if no parameters are required.

    The right side is the lambda body which specifies the actions of the
    lambda expression.
     */
    
    @FunctionalInterface  // optional
    interface MathOperation {
        int operation(int a, int b);  // abstract by default
    }

    @FunctionalInterface  // optional
    interface GreetingService {
        void sayMessage(String message);  // abstract by default
    }

    @FunctionalInterface  // optional
    interface Sayable {
        public String say();  // abstract by default
    }

    public static void main(String[] args) {

        //@@@@@ anonymous functions/class
        // can have declared variables inside block of code
        
        MathOperation mathOperation = new MathOperation() {
            @Override
            public int operation(int a, int b) {
                return a + b;
            }
        };
        mathOperation.operation(5, 10);

        //@@@@@ lambda expressions
        // Lambda expressions basically express instances of functional interfaces
        // i.e. single abstract method interface
        // but can have any number of default & static methods
        // cannot have declared variables inside block of code
        // in same cases can be converted to method references.. (look it up!)
        
        // with type declaration
        MathOperation addition = (int a, int b) -> a + b;
        addition.operation(5, 10);
        // or
        int aa = addition.operation(5, 10);

        // without type declaration
        MathOperation subtraction = (a, b) -> a - b;
        subtraction.operation(5, 10);
        // or
        int bb = subtraction.operation(5, 10);

        // with return statement along with curly braces
        MathOperation multiplication = (int a, int b) -> {
            return a * b;
        };
        multiplication.operation(5, 10);
        // or
        int cc = multiplication.operation(5, 10);

        // without return statement and without curly braces
        MathOperation division = (int a, int b) -> a / b;
        division.operation(5, 10);
        // or
        double dd = division.operation(5, 10);

        // without parenthesis
        GreetingService greetService1 = message -> System.out.println("Hello " + message);
        greetService1.sayMessage("Mahesh");

        // with parenthesis
        GreetingService greetService2 = (message) -> System.out.println("Hello " + message);
        greetService2.sayMessage("Suresh");

        // no parameter
        Sayable s = () -> {
            return "I have nothing to say.";
        };
        System.out.println(s.say());

    }

}
        
/*
        
        @@@@@ example foreach loop
        
        import java.util.*;  
        public class LambdaExpressionExample7{  
            public static void main(String[] args) {  

                List<String> list=new ArrayList<String>();  
                list.add("ankit");  
                list.add("mayank");  
                list.add("irfan");  
                list.add("jai");  

                list.forEach(  
                    (n)->System.out.println(n)  
                );  
            }  
        }  
        
        @@@@@ example thread
        
        public class LambdaExpressionExample9{
            public static void main(String[] args) {

                // Thread Example without lambda
                Runnable r1=new Runnable(){
                    public void run(){
                        System.out.println("Thread1 is running...");
                    }
                };
                Thread t1=new Thread(r1);
                t1.start();
                // Thread Example with lambda
                Runnable r2=()->{
                        System.out.println("Thread2 is running...");
                };
                Thread t2=new Thread(r2);
                t2.start();
                // or?
                new Thread(
                    () -> System.out.println("My Runnable");
                ).start();
            }
        }
        
        @@@@@ example comparator
        
        import java.util.ArrayList;  
        import java.util.Collections;  
        import java.util.List;  
        class Product{  
            int id;  
            String name;  
            float price;  
            public Product(int id, String name, float price) {  
                super();  
                this.id = id;  
                this.name = name;  
                this.price = price;  
            }  
        }  
        public class LambdaExpressionExample10{  
            public static void main(String[] args) {  
                List<Product> list=new ArrayList<Product>();  

                //Adding Products  
                list.add(new Product(1,"HP Laptop",25000f));  
                list.add(new Product(3,"Keyboard",300f));  
                list.add(new Product(2,"Dell Mouse",150f));  

                System.out.println("Sorting on the basis of name...");  

                // implementing lambda expression  
                Collections.sort(list,(p1,p2)->{  
                return p1.name.compareTo(p2.name);  
                });  
                for(Product p:list){  
                    System.out.println(p.id+" "+p.name+" "+p.price);  
                }  

            }  
        }  
        
        @@@@@ example filter collection data
        
        import java.util.ArrayList;  
        import java.util.List;  
        import java.util.stream.Stream;   
        class Product{  
            int id;  
            String name;  
            float price;  
            public Product(int id, String name, float price) {  
                super();  
                this.id = id;  
                this.name = name;  
                this.price = price;  
            }  
        }  
        public class LambdaExpressionExample11{  
            public static void main(String[] args) {  
                List<Product> list=new ArrayList<Product>();  
                list.add(new Product(1,"Samsung A5",17000f));  
                list.add(new Product(3,"Iphone 6S",65000f));  
                list.add(new Product(2,"Sony Xperia",25000f));  
                list.add(new Product(4,"Nokia Lumia",15000f));  
                list.add(new Product(5,"Redmi4 ",26000f));  
                list.add(new Product(6,"Lenevo Vibe",19000f));  

                // using lambda to filter data  
                Stream<Product> filtered_data = list.stream().filter(p -> p.price > 20000);  

                // using lambda to iterate through collection  
                filtered_data.forEach(  
                        product -> System.out.println(product.name+": "+product.price)  
                );  
            }  
        }  
        
        @@@@@ example event listener
        
        import javax.swing.JButton;  
        import javax.swing.JFrame;  
        import javax.swing.JTextField;  
        public class LambdaEventListenerExample {  
            public static void main(String[] args) {  
                JTextField tf=new JTextField();  
                tf.setBounds(50, 50,150,20);  
                JButton b=new JButton("click");  
                b.setBounds(80,100,70,30);  

                // lambda expression implementing here.  
                b.addActionListener(e-> {tf.setText("hello swing");});  

                JFrame f=new JFrame();  
                f.add(tf);f.add(b);  
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
                f.setLayout(null);  
                f.setSize(300, 200);  
                f.setVisible(true);  

            }  

        } 
        
*/
