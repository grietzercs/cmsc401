import java.util.*;

public class hw4 {

    public static Hashtable<Integer, Integer> ht = new Hashtable<>();
    public static int beforeSize = 0; 
    public static int afterSize = 0;
    public static int i = 0;
    public static void main(String[] args) throws Exception {        

        Scanner userInput = new Scanner(System.in);
        ArrayList<String> inputList = new ArrayList<>();
        boolean endUserInput = false; int iterate = 0;
        while (!endUserInput) {
            inputList.add(userInput.nextLine());
            if (inputList.get(iterate).compareTo("QUIT") == 0) {
                endUserInput = true;
            }
            iterate++;
        }
        for (int i=0; i < inputList.size(); i++) {
            getInput(inputList.get(i));
        }
    }

    public static void getInput(String inputString) {
        String newString = inputString.replace("x", "");
        Scanner scanner = new Scanner(newString);

        String modifier = "x"; int modifierCount = 0;
        int key = 0; int value = 0;
        int varnameL = 0; int varnameR1 = 0; int varnameR2 = 0;
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                if (modifierCount == 0 ) {
                    key = scanner.nextInt();
                    varnameL = key;
                }
                if (modifierCount == 1) {
                    value = scanner.nextInt();
                    varnameR1 = value;
                }
                if (modifierCount == 2) {
                    varnameR2 = scanner.nextInt();
                }
            }
            else {
                modifier = scanner.next();
                if (modifier.compareTo("QUIT") == 0) {
                    System.exit(0);
                }
                modifierCount++;
            }
        }

        if (varnameL > 0 && varnameR1 > 0 && varnameR2 > 0) {
            if (ht.get(varnameR1) == null) {
                System.out.println("ERROR");
                System.exit(0);
            }
            if (ht.get(varnameR2) == null) {
                System.out.println("ERROR");
                System.exit(0);
            }
            else {
                if (modifier.compareTo("-") == 0) {
                    ht.put(varnameL, (ht.get(varnameR1) - ht.get(varnameR2)));
                    System.out.println(ht.get(varnameL));
                }
                if (modifier.compareTo("+") == 0) {
                    ht.put(varnameL, (ht.get(varnameR1) + ht.get(varnameR2)));
                    System.out.println(ht.get(varnameL));
                }
                if (modifier.compareTo("*") == 0) {
                    ht.put(varnameL, (ht.get(varnameR1) * ht.get(varnameR2)));
                    System.out.println(ht.get(varnameL));
                }
            }
        }
        else {
            if (ht.get(key) != null) {
                System.out.println("ERROR");
                System.exit(0);
            }
            ht.put(key, value);
            System.out.println(ht.get(key));
            afterSize++;
        }
        scanner.close();
    }
}
