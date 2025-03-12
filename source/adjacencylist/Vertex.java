package source.adjacencylist;

public class Vertex {
    public String label;
    public boolean visited;

    public Vertex(String label) {
        this.label = label;
        this.visited = false;
    }

    @Override
    public String toString() {
        return label;
    }
}
