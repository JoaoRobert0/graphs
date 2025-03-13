package source.algorithms.dfs;

import java.util.ArrayList;

import source.adjacencylist.Edge;
import source.adjacencylist.Graph;
import source.adjacencylist.Vertex;

public class GraphDFS extends Graph{
    private int time;
    
    public void dfs() {
        time = 0;

        for (Vertex v : vertices) {
            v.color = "white";
            v.distance = 0;
            v.f = 0;
            v.father = null;
        }

        for (Vertex v : vertices) {
            if (v.color == "white") {
                dfsRecursive(v);
            }
        }
    }

    public void dfsRecursive(Vertex v) {
        System.out.println("Visiting the vertex: " + v.label);
        time += 1;

        v.color = "grey";
        v.distance = time;

        int indexVertex = vertices.indexOf(v);
        for (Edge edge : adjList.get(indexVertex)) {
            Vertex adjVertex = edge.destination;
            if (adjVertex.color == "white") {
                adjVertex.father = v;
                dfsRecursive(adjVertex);
            }
        }

        time += 1;
        v.color = "black";
        v.f = time;
    }
}
