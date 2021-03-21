import java.util.Scanner;

public class cmsc401 {
    private static Scanner scanner = new Scanner(System.in);

    private static Integer readInt() {
        return scanner.nextInt();
    }

    private static void printInt(int a) {
        System.out.println(a);
    }

    static int find(int parent[], int i) {
        if (parent[i] != i) {
            parent[i] = find(parent, parent[i]);
        }
        return parent[i];
    }

    static void Union(int parent[], int x, int y) {
        int par_x = find(parent, x);
        int par_y = find(parent, y);
        parent[par_y] = par_x;
    }

    public static void main(String[] args) {
        int n, m;
        n = readInt();
        m = readInt();
        int[] parent = new int[m];
        for (int i = 0; i < m; i++) {
            parent[i] = i;
        }

        int a, b, c;
        for (int i = 0; i < n; i++) {
            a = readInt();
            b = readInt();
            c = readInt();

            if (a == 0) {
                Union(parent, b, c);
            } else {
                int x = find(parent, b);
                int y = find(parent, c);
                if (x != y) {
                    printInt(0);
                } else {
                    printInt(1);
                }
            }
        }
    }
}
