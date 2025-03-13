package source.adjacencymatrix;

public class Main {
    public static void main(String[] args) {
        /*
                0 1 2 3 
              ----------
            0 | 0 0 0 0 
            1 | 0 0 0 0 
            2 | 0 0 0 0 
            3 | 0 0 0 0 
         */

        Graph g = new Graph(4);
        g.display();
        g.completeGraph();
        g.display();
        g.removeVertex(0);
        g.display();
        g.addVertex();
        g.display();

        int[] pair = g.getOpposite(2, 0);
        if (pair != null) {
            for (int i : pair) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        System.out.println(g.isAdjacent(2, 0));
        System.out.println(g.isAdjacent(0, 0));

        int[] vertex = g.verticesOfEdge(2, 0);
        if (vertex != null) {
            for (int i : vertex) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
