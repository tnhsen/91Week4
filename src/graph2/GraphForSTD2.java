package graph2;

import java.util.Scanner;

public class GraphForSTD2 {
    private static int[][] adjacencyMatrix;
    private int vertexCount;
    
    public GraphForSTD2(int vertexCount) {
    	this.vertexCount = vertexCount;
    	adjacencyMatrix = new int[vertexCount][vertexCount];
    }

    public void addEdge(int source, int destination) {
    	adjacencyMatrix[source][destination] = 1;
    }

    public void printAdjacencyMatrix() {
        System.out.println("Adjacency Matrix:");
        System.out.print("  | ");
        for (int i = 0; i < vertexCount; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("-----------------------");
        for (int i = 0; i < vertexCount; i++) {
            System.out.print(i + " | ");
            for (int j = 0; j < vertexCount; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        
        System.out.print("How many vertices? ");
        int vertexCount = scanner.nextInt();
        while(vertexCount>9) {
        	System.out.println("Max vertex is 9");
        	System.out.print("How many vertices? ");
            vertexCount = scanner.nextInt();
        }
        GraphForSTD2 graph = new GraphForSTD2(vertexCount);
        
        for (int i = 0; i < vertexCount; i++) {
            System.out.println("Adjacent of vertex " + i + ":");
            while (true) {
                int adjacentVertex = scanner.nextInt();
                if (adjacentVertex == -1) {
                    break;
                }
                graph.addEdge(i, adjacentVertex);
            }
        }

        graph.printAdjacencyMatrix();
        scanner.close();
    }
}
