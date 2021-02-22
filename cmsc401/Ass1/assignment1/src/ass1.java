// Colden Grietzer
import java.util.*;

public class ass1 {
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

        System.out.println("Enter length of array: ");
        int arrayLen = readInt();
       //reading an Integer Array (you should provide the size)
        System.out.println("Enter a array of lengh " + arrayLen + ": ");
        Integer[] listOfIntegers = readIntegerArray(arrayLen);
        findNumbers(listOfIntegers);
    }

    private static void findNumbers(Integer[] intArray) {
        int i = 0; int j = 0; int k = 0;
        Integer[] resultArray = intArray;
        for (i =0; i < intArray.length; i++) {
            int minIndex = i;
            int maxIndex = i;
            for (j = i+1; j < intArray.length; j++) {
                if (intArray[j] < intArray[minIndex]) {
                    minIndex = j;
                }
                if (intArray[j] > intArray[maxIndex]) {
                    maxIndex = j;
                }
            }
            resultArray[k] = minIndex; resultArray[k+1] = maxIndex;
            
            System.out.println(intArray[maxIndex]);
            return;
        } 
    }
}