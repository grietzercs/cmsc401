//Colden Grietzer
import java.util.*;
import java.lang.*;
import java.io.*;

class cmsc401 {
  
    private static final int NO_PARENT = -1;

    private static void dijkstra(int[][] adjacencyMatrix,
                                        int startVertex)
    {
        int nVertices = adjacencyMatrix[0].length;
  
        int[] shortestDistances = new int[nVertices];
  
        boolean[] added = new boolean[nVertices];
  
        for (int vertexIndex = 0; vertexIndex < nVertices; 
                                            vertexIndex++)
        {
            shortestDistances[vertexIndex] = Integer.MAX_VALUE;
            added[vertexIndex] = false;
        }

        shortestDistances[startVertex] = 0;
  
        int[] parents = new int[nVertices];
  
        parents[startVertex] = NO_PARENT;

        for (int i = 1; i < nVertices; i++)
        {
            int nearestVertex = -1;
            int shortestDistance = Integer.MAX_VALUE;
            for (int vertexIndex = 0;
                     vertexIndex < nVertices; 
                     vertexIndex++)
            {
                if (!added[vertexIndex] &&
                    shortestDistances[vertexIndex] < 
                    shortestDistance) 
                {
                    nearestVertex = vertexIndex;
                    shortestDistance = shortestDistances[vertexIndex];
                }
            }

            added[nearestVertex] = true;
  
            for (int vertexIndex = 0;
                     vertexIndex < nVertices; 
                     vertexIndex++) 
            {
                int edgeDistance = adjacencyMatrix[nearestVertex][vertexIndex];
                  
                if (edgeDistance > 0
                    && ((shortestDistance + edgeDistance) < 
                        shortestDistances[vertexIndex])) 
                {
                    parents[vertexIndex] = nearestVertex;
                    shortestDistances[vertexIndex] = shortestDistance + 
                                                       edgeDistance;
                }
            }
        }
  
        printSolution(startVertex, shortestDistances, parents);
    }
  
    
    private static void printSolution(int startVertex,
                                      int[] distances,
                                      int[] parents)
    {
          
        int vertexIndex = 1;
        if (vertexIndex != startVertex) {
            System.out.print(distances[vertexIndex]);
            System.out.println();
        }
    }
  
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int numVertex = scanner.nextInt();
        int numEdges = scanner.nextInt();
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
        for (int i = 2; i < numVertex; i++) {
            for (int j = 0; j < 2; j++) {
                vertices[i][j] = scanner.nextInt();
            }
            vertices[i][0] -= 1;
        }

        for (int i = 0; i < numEdges; i++) {
            for (int j = 0; j < 3; j++) {
                inputArray[i][j] = scanner.nextInt();
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
            int v = inputArray[i][1];
            for (int j = 0; j < numVertex; j++) {
                if (v == vertices[j][0]) {
                    inputArray[i][2] += vertices[j][1];
                }
            }
        }

        for (int i = 0; i < numEdges; i++) {
            int u = inputArray[i][0];
            int v = inputArray[i][1];
            int value = inputArray[i][2];
            try {
                graph[u][v] = value;
            } catch (ArrayIndexOutOfBoundsException e) {
            }
        }

        dijkstra(graph, 0);
        scanner.close();
    }
}