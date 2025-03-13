package source.adjacencymatrix;

public class Graph {
    public int[][] adjMatrix;
    public int numVertices;

    public Graph(int numVertices) {
        adjMatrix = new int[numVertices][numVertices];
        this.numVertices = numVertices;
    }

    public void completeGraph() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (i == j) {
                    adjMatrix[i][j] = 0;
                } else {
                    adjMatrix[i][j] = 1;
                }
            }
        }
    }

    public void addVertex() {
        this.numVertices += 1;
        int[][] newAdjMatrix = new int[numVertices][numVertices];

        // Append a new vertex (new row and collumn)
        for (int i = 0; i < numVertices - 1; i++) {
            for (int j = 0; j < numVertices - 1; j++) {
                newAdjMatrix[i][j] = adjMatrix[i][j];
            }
        }

        adjMatrix = newAdjMatrix;
    }

    public void addEdge(int v1, int v2, boolean both) {
        // Valid vertices
        if (v1 >= 0 && v1 < numVertices && v2 >= 0 && v2 < numVertices) {
            adjMatrix[v1][v2] += 1;
            if (both) {
                adjMatrix[v2][v1] += 1;
            }
        }
    }

    public void removeVertex(int v) {
        if (v >= 0 && v < numVertices) {
            int[][] newAdjMatrix = new int[numVertices - 1][numVertices - 1];
    
            for (int i = 0, newRow = 0; i < numVertices; i++) {
                if (i == v) continue; // Ignore row
 
                for (int j = 0, newCol = 0; j < numVertices; j++) {
                    if (j == v) continue; // Ignore collumn

                    newAdjMatrix[newRow][newCol] = adjMatrix[i][j];
                    newCol += 1;
                }
                newRow += 1;
            }
    
            adjMatrix = newAdjMatrix;
            numVertices -= 1;
        }
    }

    public void removeEdge(int v1, int v2, boolean both) {
        // Valid vertices
        if (v1 >= 0 && v1 < numVertices && v2 >= 0 && v2 < numVertices) {
            if (adjMatrix[v1][v2] > 0) {
                adjMatrix[v1][v2] -= 1;
            }
            if (both) {
                if (adjMatrix[v2][v1] > 0) {
                    adjMatrix[v2][v1] -= 1;
                }
            }
        }
    }

    public int[] getOpposite(int v, int collEdge) {
        if (
            v >= 0 && v < numVertices &&
            collEdge >= 0 && collEdge < numVertices
        ) {
            if (adjMatrix[v][collEdge] > 0) {
                return new int[] {collEdge, v};
            }
        }
        return null;
    }

    public boolean isAdjacent(int v1, int v2) {
        if (v1 >= 0 && v1 < numVertices && v2 >= 0 && v2 < numVertices) {
            return getOpposite(v1, v2) != null;
        }
        return false;
    }
    
    public int[] verticesOfEdge(int row, int col) {
        if (
            row >= 0 && row < numVertices &&
            col >= 0 && col < numVertices
        ) {
            if (adjMatrix[row][col] > 0) {
                return new int[] {row, col};
            }
        }
        return null;
    }

    public void display() {
        System.out.print("    ");
        for (int i = 0; i < numVertices; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.print("  --");
        for (int i = 0; i < numVertices; i++) {
            System.out.print("--");
        }
        System.out.println();

        for (int i = 0; i < numVertices; i++) {
            System.out.print(i + " | ");
            for (int j = 0; j < numVertices; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
