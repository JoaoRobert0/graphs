package source.adjacencylist;

import java.util.ArrayList;

public class Graph {
    protected ArrayList<Vertex> vertices;
    protected ArrayList<ArrayList<Edge>> adjList;

    public Graph() {
        vertices = new ArrayList<>();
        adjList = new ArrayList<>();
    }

    public void addVertex(Vertex vertex) {
        vertices.add(vertex);
        adjList.add(new ArrayList<>());
    }

    public Edge addEdge(Vertex origin, Vertex destination, double weight) {
        int indexOrigin = vertices.indexOf(origin);
        int indexDestination = vertices.indexOf(destination);

        if (indexOrigin != -1 && indexDestination != -1) {
            Edge edge = new Edge(origin, destination, weight);
            adjList.get(indexOrigin).add(edge);
            return edge;
        } else {
            System.out.println("Vertices not found.");
        }
        return null;
    }

    public Vertex removeVertex(Vertex v) {
        int indexVertex = vertices.indexOf(v);

        vertices.remove(indexVertex);
        adjList.remove(indexVertex);

        for (int i = 0; i < adjList.size(); i++) {
            ArrayList<Edge> adjVertex = adjList.get(i);

            // Delete each edge from the last to first index to avoid error
            for (int j = adjVertex.size() - 1; j >= 0; j--) { 
                Edge edge = adjVertex.get(j);
                if (edge.origin == v || edge.destination == v) {
                    adjVertex.remove(edge);
                }
            }
        }

        return v;
    }

    public Edge removeEdge(Edge e) {
        for (ArrayList<Edge> adjVertex : adjList) {
            if (adjVertex.contains(e)) {
                adjVertex.remove(e);
                return e;
            }
        }
        return null;
    }

    public Vertex oppositeVertex(Vertex v, Edge e) {
        if (e.origin == v) return e.destination;
        else if (e.destination == v) return e.origin;
        return null;
    }

    public String isAdjacent(Vertex v1, Vertex v2) {
        int v1Index = vertices.indexOf(v1);
        int v2Index = vertices.indexOf(v2);

        if (v1Index == -1 || v2Index == -1) {
            return "Some vertex not exist!";
        }

        ArrayList<Edge> v1Adj = adjList.get(v1Index);
        ArrayList<Edge> v2Adj = adjList.get(v2Index);

        boolean v1Is = false; 
        for (Edge edge : v1Adj) {
            if (edge.destination == v2) {
                v1Is = true;
                break;
            }
        }
        
        boolean v2Is = false;
        for (Edge edge : v2Adj) {
            if (edge.destination == v1) {
                v2Is = true;
                break;
            }
        }

        if (v1Is == true && v2Is == true) {
            return v1.label + "<->" + v2.label;
        } else if (v1Is == true) {
            return v1.label + "->" + v2.label;
        } else if (v2Is == true) {
            return v2.label + "->" + v1.label;
        } else {
            return "Vertices not adjacent";
        }        
    }

    public void changeVertexLabel(Vertex v, String newLabel) {
        v.label = newLabel;
    }

    public void changeEdgeWeight(Edge e, double newWeight) {
        e.weight = newWeight;
    }

    public ArrayList<Vertex> verticesOfEdge(Edge e) {
        ArrayList<Vertex> verticesOfEdge = new ArrayList<>();
        verticesOfEdge.add(e.origin);
        verticesOfEdge.add(e.destination);
        return verticesOfEdge;
    }
    public void display() {
        System.out.println("Graph:");
        for (int i = 0; i < adjList.size(); i++) {
            System.out.print(vertices.get(i) + " -> "); // Return the label of the vertex
            for (Edge edge : adjList.get(i)) {
                System.out.print(edge.destination + " (" + edge.weight + "), ");
            }
            System.out.println();
        }
    }
    
}
