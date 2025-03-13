package source.algorithms.bfs;

import source.adjacencylist.Edge;
import source.adjacencylist.Graph;
import source.adjacencylist.Vertex;

import java.util.Queue;
import java.util.LinkedList;

public class GraphBFS extends Graph{
    public void bfs(Vertex initialVertex) {
        initialVertex.color = "grey";
        initialVertex.distance = 0;
        initialVertex.father = null;

        Queue<Vertex> queue = new LinkedList<>();
        queue.add(initialVertex);

        while (queue.size() != 0) {
            Vertex currentVertex = queue.poll();

            System.out.println(
                "Visiting the vertex: " + currentVertex.label +
                " - " + currentVertex.father + " - " + currentVertex.distance
            );
           
            int indexVertex = vertices.indexOf(currentVertex);

            for (Edge edge : adjList.get(indexVertex)) {
                if (edge.destination.color == "white") {
                    edge.destination.color = "grey";
                    edge.destination.father = edge.origin;
                    edge.destination.distance = currentVertex.distance + 1;

                    queue.add(edge.destination);
                }
            }

            currentVertex.color = "black";
        }
    }
}
