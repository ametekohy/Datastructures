import java.util.LinkedList;
import java.util.List;

public class Vertex {
    public String name;
    public List<Edge> adj;
    public double dist; // cost
    public Vertex prev;
    public int scratch; // extra variable

    public Vertex(String nm) {
        this.name = nm;
        this.adj = new LinkedList<Edge>();
        this.reset();
    }

    public void reset() {
        this.dist = Graph.INFINITY; // dist = Double.POSITIVE_INFINITY
        this.prev = null;
//        pos = null;
        this.scratch = 0;
    }
}
