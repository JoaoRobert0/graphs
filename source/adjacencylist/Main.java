package source.adjacencylist;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        /* 
        * Example:
        *    A
        * /  |  \
        * B  C   D
        * |  |    \>
        * E  F     G
        */  

        Graph graph = new Graph();

        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        Vertex e = new Vertex("E");
        Vertex f = new Vertex("F");
        Vertex g = new Vertex("G");

        graph.addVertex(a);
        graph.addVertex(b);
        graph.addVertex(c);
        graph.addVertex(d);
        graph.addVertex(e);
        graph.addVertex(f);
        graph.addVertex(g);

        Edge ab = graph.addEdge(a, b, 1);
        Edge ac = graph.addEdge(a, c, 1);
        Edge ad = graph.addEdge(a, d, 1);

        Edge ba = graph.addEdge(b, a, 1);
        Edge be = graph.addEdge(b, e, 1);

        Edge ca = graph.addEdge(c, a, 1);
        Edge cf = graph.addEdge(c, f, 1);

        Edge da = graph.addEdge(d, a, 1);
        Edge dg = graph.addEdge(d, g, 1);

        Edge eb = graph.addEdge(e, b, 1);

        Edge fc = graph.addEdge(f, c, 1);


        graph.display();

        graph.removeVertex(a);
        graph.display();

        graph.removeEdge(eb);
        graph.display();

        System.out.println(graph.oppositeVertex(c, cf));
        System.out.println(graph.oppositeVertex(f, cf));

        System.out.println(graph.isAdjacent(c, f));
        System.out.println(graph.isAdjacent(a, b));
        System.out.println(graph.isAdjacent(d, g));
        System.out.println(graph.isAdjacent(g, d));

        ArrayList<Vertex> verticesOfEdge = graph.verticesOfEdge(be);
        for (Vertex v : verticesOfEdge) {
            System.out.println(v);
        }
    }
}
