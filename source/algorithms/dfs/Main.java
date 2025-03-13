package source.algorithms.dfs;

import source.adjacencylist.Vertex;

public class Main {
    public static void main(String[] args) {
        GraphDFS g = new GraphDFS();

        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        Vertex e = new Vertex("E");

        g.addVertex(a);
        g.addVertex(b);
        g.addVertex(c);
        g.addVertex(d);
        g.addVertex(e);

        g.addEdge(a, b, 1);
        g.addEdge(a, c, 1);
        g.addEdge(b, d, 1);
        g.addEdge(c, d, 1);
        g.addEdge(d, e, 1);

        g.display();
        g.dfs();
    }
}