
package a_functional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class G_arrays {
    
    public static void main(String[] args) {
        
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< definitions >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        /*
        array is variable that hold bunch of boxes (filled with other boxes)
        Each box has a number on it called an index
	An array can contain only values of the same type (including objects)
        An arrays size can't be changed once it is set
        An array is an object
	 */
        
        // various definitions
        int[] brojevi = { 3, 2, 5, 1, 8, 4, 88, 32, 11, 23 };
        int[][] doubleArray = {{ 2, 4, 8 }, { 1, 9, 3 }, { 2, 5, 1 }};
        char[] slova = { 'a', 'z' };
        String reci[] = { "sima", "petar" };
        Integer[] wrapper = new Integer[]{3, 2, 4, 6, 2, 4, 2, 2, 1, 2};
        // use interface wrapper for objects of different type
        Object[] objects = new Object[5];
        
        String[][][] tripleArray = // [rows][columns][whole sets]
                {
                        { { "000" }, { "100" }, { "200" }, { "300" } },
                        { { "010" }, { "110" }, { "210" }, { "310" } },
                        { { "020" }, { "120" }, { "220" }, { "320" } }
                };
        
        // declarations (default values are 0 for ints and 0.0 for doubles)
        int[] brojevi2 = new int[101];
        String[][] doubleArray2 = new String[10][10];
        int[][] doubleArray3 = new int[3][3];
        
        // nazupceni niz (has subarrays of different size)
        String[][] nazupceniArray 
                = {{"Just", "Random", "Words"},{"pera", "zdravko"}};
        
        // only object array can hold mix types
        Object[] objectArray = {1, "pera", 3, "zdera"};
        
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< information >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        System.out.println("duzina niza je: " + brojevi.length);
        
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< accessing directly >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        System.out.println("prvi element je: " + brojevi[0]);
        System.out.println("clan niza je" + doubleArray[1][2]);
        brojevi[1] = 2;
        reci[1].toString();
        
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< accessing iterating >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        for (int i=0; i<10; i++) {
            brojevi[i] = i;
            System.out.println(brojevi[i]);
        }
        
        for(int i = 0; i < doubleArray.length; i++){
            for(int j = 0; j < doubleArray[i].length; j++){
                doubleArray[i][j] = i + j;
                // or something like if needed
                // doubleArray[i+2][j*brojevi.lenght()] = i*3;
                System.out.print("| " + doubleArray[i][j] + " ");
            }
            System.out.println("|");
        }
        
        for(int i = 0; i < tripleArray.length; i++){
            for(int j = 0; j < tripleArray[i].length; j++){
                for(int k = 0; k < tripleArray[i][j].length; k++){
                    tripleArray[i][j][k] = tripleArray[i][j][k] + "z";
                    System.out.print("| " + tripleArray[i][j][k] + " ");
                }
            }
        }

        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< default value >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        /*
        filling single line array
        Arrays.fill(arrayName, valueToFill);
        */
        Arrays.fill(brojevi, 2);
        
        // filling any array
        char[][] boardGame = new char[10][10];
        for(char[] row : boardGame){
            Arrays.fill(row, '*');
        }
        
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< copying >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        /*
        copy single line array
        Arrays.copyOf(arrayToCopy, newLenght);
        */
        int[] brojevi5 = Arrays.copyOf(brojevi, 8);
        // You can copy an array from one index to another with copyOfRange
        int[] brojevi6 = Arrays.copyOfRange(brojevi, 1, 5);
        // native method clone for copying
        int[] brojevi7 = brojevi.clone();
        
        // copy any array (manual method)
        for(int i=0; i<doubleArray.length; i++){
            for(int j=0; j<doubleArray[i].length; j++){
                doubleArray[i][j]=doubleArray3[i][j];
            }
        }

        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< sorting >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        // Sort the single line array in ascending order
        Arrays.sort(brojevi);
        
        // for sorting 2d & 3d arrays use comparator (unclear)

        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< searching >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        /*
        binarySearch for single line array returns the index for the searched
        for value if it doesn't find it it returns a negative number
        */
        int index = Arrays.binarySearch(brojevi, 50);
        
        // searching any array
        for (int i = 0; i < doubleArray.length; i++) {
            for (int j = 0; j < doubleArray[i].length; j++) {
                if (doubleArray[i][j]==33){
                    System.out.println(doubleArray[i][j] + " " + i + " " + j);
                }
            }
        }

        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< converting >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        /*
        convert array to list (must be referenced type)
        bug: asList won't receive variable representing array
        */
        List<Integer> brojevi3 = Arrays.asList(3, 4, 6);
        // or from java 9 & above
        List<Integer> brojevi8 = List.of(3, 4, 6);
        // convert list to arraylist
        ArrayList<Integer> brojevi4 = new ArrayList<>(brojevi3);
    }
}
