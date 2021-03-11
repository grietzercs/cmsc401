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

        //read array length
        int arrayLen = readInt();
        //reading an Integer Array (you should provide the size)
        Integer[] listOfIntegers = readIntegerArray(arrayLen);

        listOfIntegers = findNumbers(listOfIntegers);
        printArray(listOfIntegers);
    }

    private static Integer[] findNumbers(Integer[] intArray) {
        int i = 0; int j = 0;
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
            if (intArray[i] < intArray[maxIndex] && ((i%2) <= 0)) {
                int temp = intArray[maxIndex];
                intArray[maxIndex] = intArray[i];
                intArray[i] = temp;
            }
            if (intArray[i] > intArray[minIndex] && ((i%2) > 0)) {
                int temp = intArray[minIndex];
                intArray[minIndex] = intArray[i];
                intArray[i] = temp;
            }
        }
        return intArray;
    }

    private static void printArray(Integer[] intArray) {
        System.out.println();
        int n = intArray.length;
        for (int i=0; i<n; ++i)
            System.out.println(intArray[i]);
        System.out.println();
    }
}