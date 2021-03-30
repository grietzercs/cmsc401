// Colden Grietzer
import java.util.*;

import jdk.tools.jaotc.binformat.elf.AMD64JELFRelocObject;

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

        int numVertex = readInt();
        System.out.println("# of vertices: " + numVertex);
        int numEdges = readInt();
        int inputArray[][] = new int[numVertex][numEdges];
        int exampleArray[][] = new int[numVertex][numEdges];


        for (int i = 0; i < numVertex; i++) {
            for (int j = 0; j < numEdges; j++) {
                inputArray[i][j] = scanner.nextInt();
                exampleArray[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < numVertex; i++) {
            int u = inputArray[i][0];
            int v = inputArray[i][1];
            int value = inputArray[i][2];
            exampleArray[u][v] = value;
        }

        //remove this later and add vertices and edges directly
        int[][] vertices = new int[numVertex][2];
        for (int i = 0; i < numVertex; i++) {
            for (int j = 0; j < 2; j++) {
                vertices[i][j] = scanner.nextInt();
            }
        }
        int[][] edges = new int[numEdges][3];
        for (int i = 0; i < numEdges; i++) {
            for (int j = 0; j < 3; j++) {
                edges[i][j] = scanner.nextInt();
            }
        }
        
        System.out.println(numVertex);
        System.out.println(numEdges);
        for (int i = 0; i < numVertex; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.println(vertices[i][j]);
            }
        }

        int j=0;
        Graph graph = new Graph(numVertex, numEdges);
        for (int i = 0; i < numVertex; i++) {
            int vertex = vertices[i][j];
            int motelCost = vertices[i][j+1];
            graph.addVertex(vertex, motelCost);
        }
        for (int i = 0; i < numEdges; i++) {
            int source = edges[i][j];
            int destination = edges[i][j+1];
            int weight = edges[i][j+2];
            graph.addEdge(source, destination, weight);
        }
    }

    static class Vertex {
        int numVertex, motelCost;
        public Vertex(int numVertex, int motelCost) {
            this.numVertex = numVertex;
            this.motelCost = motelCost;
        }
    }

    static class Edge {
        int source, destination, weight;
        public Edge (int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    static class Graph {
        int vertices;
        int edges;
        LinkedList<Edge>[] edgeList;
        LinkedList<Vertex>[] vertexList;
        Graph(int vertices, int edges) {
            this.vertices = vertices;
            this.edges = edges;
            edgeList = (LinkedList<Edge>[]) new LinkedList<?>[edges];
            vertexList = (LinkedList<Vertex>[]) new LinkedList<?>[vertices];
            //initialize adjacency lists for all the vertices
            for (int i = 0; i < edges; i++) {
                edgeList[i] = (LinkedList<Edge>[]) new LinkedList<?>();
            }
            for (int i = 0; i < vertices; i++) {
                vertexList[i] = (LinkedList<Vertex>[]) new LinkedList<?>();
            }
        }

        public void addEdge(int source, int destination, int weight) {
            Edge edge = new Edge(source, destination, weight);
            edgeList[source].addFirst(edge); //for directed graph
        }

        public void addVertex(int numVertex, int motelCost) {
            Vertex vertex = new Vertex(numVertex, motelCost);
            vertexList[numVertex].addFirst(vertex);
        }

        // public void printGraph(Graph graph){
        //     for (int i = 0; i <vertices ; i++) {
        //         LinkedList<Edge> list = edgeList[i];
        //         for (int j = 0; j <list.size() ; j++) {
        //             System.out.println("vertex-" + i + " is connected to " +
        //                     list.get(j).destination + " with weight " +  list.get(j).weight);
        //         }
        //     }
        // }
    }
}
