package source.algorithms.bfs;

import source.adjacencylist.Edge;
import source.adjacencylist.Vertex;

public class Main {
    public static void main(String[] args) {
        //==============================================
        GraphBFS g1 = new GraphBFS();

        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");        
        Vertex c = new Vertex("C");
        
        g1.addVertex(a);
        g1.addVertex(b);
        g1.addVertex(c);

        Edge ab = g1.addEdge(a, b, 1);
        Edge ac = g1.addEdge(a, c, 1);

        Edge ba = g1.addEdge(b, a, 1);

        Edge ca = g1.addEdge(c, a, 1);

        g1.display();
        g1.bfs(a);
        //==============================================

        //==============================================
        GraphBFS g2 = new GraphBFS();

        a = new Vertex("A");
        b = new Vertex("B");        
        c = new Vertex("C");
        Vertex d = new Vertex("D");

        g2.addVertex(a);
        g2.addVertex(b);
        g2.addVertex(c);
        g2.addVertex(d);

        ab = g2.addEdge(a, b, 1);
        ac = g2.addEdge(a, c, 1);
        Edge bc = g2.addEdge(b, c, 1);
        Edge cd = g2.addEdge(c, d, 1);

        g2.display();
        g2.bfs(a);
        //==============================================

        //==============================================
        GraphBFS g3 = new GraphBFS();

        a = new Vertex("A");
        b = new Vertex("B");        
        c = new Vertex("C");
        d = new Vertex("D");
        Vertex e = new Vertex("E");

        g3.addVertex(a);
        g3.addVertex(b);
        g3.addVertex(c);
        g3.addVertex(d);
        g3.addVertex(e);

        ab = g3.addEdge(a, b, 1);
        ac = g3.addEdge(a, c, 1);
        Edge bd = g3.addEdge(b, d, 1);
        cd = g3.addEdge(c, d, 1);
        Edge de = g3.addEdge(d, e, 1);
        Edge ae = g3.addEdge(a, e, 1);
        Edge ec = g3.addEdge(e, c, 1);

        g3.display();
        g3.bfs(a);
        //==============================================
    }
}
