import java.util.*;
import java.lang.*;
import java.io.*;
  
class ShortestPath {
    private static final Scanner scanner = new Scanner(System.in);
    // A utility function to find the vertex with minimum distance value,
    // from the set of vertices not yet included in shortest path tree
    static int V = 5;
    int minDistance(int dist[], Boolean sptSet[])
    {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index = -1;
  
        for (int v = 0; v < V; v++)
            if (sptSet[v] == false && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }
  
        return min_index;
    }
  
    // A utility function to print the constructed distance array
    void printSolution(int dist[], int n)
    {
        System.out.println("Vertex   Distance from Source");
        for (int i = 0; i < V; i++)
            System.out.println(i + " tt " + dist[i]);
    }
  
    // Function that implements Dijkstra's single source shortest path
    // algorithm for a graph represented using adjacency matrix
    // representation
    void dijkstra(int graph[][], int src)
    {
        int dist[] = new int[V]; // The output array. dist[i] will hold
        // the shortest distance from src to i
        int distv[] = new int[V]; //holds "motel cost" for each vertex
  
        // sptSet[i] will true if vertex i is included in shortest
        // path tree or shortest distance from src to i is finalized
        Boolean sptSet[] = new Boolean[V];
        Boolean sptSetv[] = new Boolean[V];
  
        // Initialize all distances as INFINITE and stpSet[] as false
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            distv[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
            sptSetv[i] = false;
        }
  
        // Distance of source vertex from itself is always 0
        dist[src] = 0;
  
        // Find shortest path for all vertices
        for (int count = 0; count < V - 1; count++) {
            // Pick the minimum distance vertex from the set of vertices
            // not yet processed. u is always equal to src in first
            // iteration.
            int u = minDistance(dist, sptSet);
  
            // Mark the picked vertex as processed
            sptSet[u] = true;
  
            // Update dist value of the adjacent vertices of the
            // picked vertex.
            for (int v = 0; v < V; v++)
  
                // Update dist[v] only if is not in sptSet, there is an
                // edge from u to v, and total weight of path from src to
                // v through u is smaller than current value of dist[v]
                if (!sptSet[v] && graph[u][v] != 0 && 
                   dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v];
        }
  
        // print the constructed distance array
        printSolution(dist, V);
    }
  
    // Driver method
    public static void main(String[] args)
    {
        int numVertex = scanner.nextInt();
        V = numVertex;
        System.out.println("# of vertices: " + numVertex);
        int numEdges = scanner.nextInt();
        System.out.println("# of edges: " + numEdges);
        int inputArray[][] = new int[numEdges][3];
        int graph[][] = new int[numVertex][numVertex];
        int vertices[][] = new int[numVertex][2];
        
        for (int i = 2; i < numVertex; i++) {
            for (int j = 0; j < 2; j++) {
                vertices[i][j] = 0;
            }
        }

        vertices[0][0] = 0; vertices[0][1] = 0; 
        vertices[1][0] = 1; vertices[1][1] = 0; 
        System.out.println("Start input for vertices");
        for (int i = 2; i < numVertex; i++) {
            for (int j = 0; j < 2; j++) {
                vertices[i][j] = scanner.nextInt();
                System.out.println("Received input");
            }
            vertices[i][0] -= 1;
        }

        System.out.println("Start input for edges");
        for (int i = 0; i < numEdges; i++) {
            for (int j = 0; j < 3; j++) {
                inputArray[i][j] = scanner.nextInt();
                //System.out.println("Received input");
            }
            inputArray[i][0] -= 1;
            inputArray[i][1] -= 1;
        }

        for (int i = 0; i < numVertex; i++) {
            for (int j = 0; j < numVertex; j++) {
                graph[i][j] = 0;
            }
        }

        for (int i = 0; i < numEdges; i++) {
            int u = inputArray[i][0];
            int v = inputArray[i][1];
            int value = inputArray[i][2];
            try {
                graph[u][v] = value;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Value of " + i + ": " + i);
            }
        }

        for (int i = 0; i < numVertex; i++) {  vertices[i][0] -= 1;
            for (int j = 0; j < numVertex; j++) {
                if ((vertices[i][1] > 0) && (graph[i][j] > 0)) {
                    graph[i][j] += vertices[i][1];
                }
            }
        }
        System.out.println("Done");
        ShortestPath t = new ShortestPath();
        t.dijkstra(graph, 0);
    }
}
// This code is contributed by Aakash Hasij