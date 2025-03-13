package source.adjacencylist;

public class Vertex {
    public String label;
    public boolean visited;
    public String color;
    public Vertex father;
    public int distance;
    public int f;

    public static final int INFINITY = Integer.MAX_VALUE; 

    public Vertex(String label) {
        this.label = label;
        this.visited = false;
        this.color = "white";
        this.father = null;
        this.distance = INFINITY;
        this.f = 0;
    }

    @Override
    public String toString() {
        return label;
    }
}
