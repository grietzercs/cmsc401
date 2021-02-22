// Colden Grietzer
import java.util.*;

public class cmsc401 {
    private static final Scanner scanner = new Scanner(System.in);

    // Please use these methods to take inputs and write outputs.
    private static Integer readInt() {
        return scanner.nextInt();
    }

    private static String readString() {
        return scanner.next();
    }

    private static Integer[] readIntegerArray(int size) {
        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = readInt();
        }
        return array;
    }

    private static void findNumbers(Integer[] intArray) {
        int secondLarge = 0;
        int bigLarge = intArray[0];
        for (int i=1; i < intArray.length; i++) {
            if (bigLarge < intArray[i]) {
                secondLarge = bigLarge;
                bigLarge = intArray[i];
            }
            if (secondLarge < intArray[i] && bigLarge > intArray[i]) {
                secondLarge = intArray[i];
            }
        }
        System.out.println(secondLarge);
    }

    private static void printInt(int a) {
        System.out.println(a);
    }

    private static void printString(String s) {
        System.out.println(s);
    }

    public static void main(String[] args) {

    //    // reading an Integer
    //    Integer a = readInt();
    //    // writing int output
    //    printInt(a);

    //    //reading a String
    //    String s = readString();
    //    //writing string output
    //    printString(s);

       //reading an Integer Array (you should provide the size)
        System.out.println("Enter a array of length 5: ");
        Integer[] listOfIntegers = readIntegerArray(5);
        determineSecondLargest(listOfIntegers);
        //write your code here
    }
}