package source.adjacencylist;

public class Edge {
    public Vertex origin;
    public Vertex destination;
    public double weight;

    public Edge(Vertex origin, Vertex destination, double weight) {
        this.origin = origin;
        this.destination = destination;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return origin + " -> " + destination + " (" + weight + ")";
    }
}
