// you name here
import java.util.*;

public class hw2 {
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

        Integer[] initialInput = {500, 1000};
        int numInputs = 500;
        int numCitizens = 1000;

        Integer[][] inputArrays = new Integer[numInputs][3];
        //inputArrays = readInput(inputArrays, numInputs);
        inputArrays = programmaticInput(inputArrays, numInputs, numCitizens);

        //printArray(inputArrays, numInputs);

        Integer[] parents = new Integer[numCitizens];
        parents = setupParentArray(parents, numCitizens);

        interpretInput(inputArrays, parents, numInputs);
    }

    private static Integer[][] programmaticInput(Integer[][] inputArrays, int numInputs, int numCitizens) {
        int leftCount = 0;
        int rightCount = numCitizens-1;
        for (int i = 0; i < (numInputs/2); i++) {
            inputArrays[i][0] = 0;
            inputArrays[i][1] = leftCount;
            inputArrays[i][2] = rightCount;
            //System.out.println(inputArrays[i][0] + " " + inputArrays[i][1] + " " + inputArrays[i][2]);
            if ((leftCount < numCitizens) && (rightCount > 0)) {
                leftCount++; rightCount--;
            }
        }
        System.out.println("End first loop");
        leftCount = 0;
        rightCount = numCitizens-1;
        for (int i=(numInputs/2); i < numInputs; i++) {
            inputArrays[i][0] = 1;
            inputArrays[i][1] = leftCount;
            inputArrays[i][2] = rightCount;
            //System.out.println(inputArrays[i][0] + " " + inputArrays[i][1] + " " + inputArrays[i][2]);
            if ((leftCount < numCitizens) && (rightCount > 0)) {
                leftCount++; rightCount--;
            }
        }
        return inputArrays;
    }

    private static void printArray(Integer[][] inputArrays, int numInputs) {
        System.out.println("Start printArray: ");
        for (int i = 0; i < numInputs; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(inputArrays[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static Integer[][] readInput(Integer[][] inputArrays, int numInputs) {
        for (int i = 0; i < numInputs; i++) {
            for (int j = 0; j < 3; j++) {
                inputArrays[i][j] = scanner.nextInt();
            }
        }
        System.out.println();
        return inputArrays;
    }

    private static Integer[] setupParentArray(Integer[] parents, int numCitizens) {
        for (int i = 0; i < numCitizens; i++) {
            parents[i] = i;
        }
        return parents;
    }

    private static void interpretInput(Integer[][] inputArrays, Integer[] parents, int numInputs) {
        for (int i = 0; i < numInputs; i++) {
            if (inputArrays[i][0] == 1) {
                isConnected(parents, inputArrays[i][1], inputArrays[i][2]);
            }
            else {
                parents = connect(parents, inputArrays[i][1], inputArrays[i][2]);
            }
        }
    }

    private static Integer[] connect(Integer[] parents, int item1, int item2) {
        parents[item2] = item1;
        return parents;
    }

    private static Integer findParent(Integer[] parents, int item) {
        if (parents[item] == item) {
            return item;
        }
        return findParent(parents, parents[item]);
    }

    private static void isConnected(Integer[] parents, int item1, int item2) {
        if (findParent(parents, item1) == findParent(parents, item2)) {
            System.out.println("1");
        }
        else {
            System.out.println("0");
        }
    }
}
