import java.util.*;

public class Graph {
    public static final double INFINITY = Double.MAX_VALUE;

    public void addEdge(String sourceName, String destName, double cost) {
        Vertex v = getVertex(sourceName);
        Vertex w = getVertex(destName);
        v.adj.add(new Edge(w, cost));
    }

    public void printPath(String destName) {
        Vertex w = vertexMap.get(destName);
        if(w == null) {
            throw new NoSuchElementException();
        } else if(w.dist == INFINITY) {
            System.out.println(destName + " is unreachable");
        } else {
            System.out.println(" (Cost is:  " + w.dist + ") ");
            printPath(w);
            System.out.println( );
        }
    }

    public void unweighted(String startName) {
        clearAll();

        Vertex start = vertexMap.get(startName);
        if(start == null) {
            throw new NoSuchElementException();
        }

        Queue<Vertex> q = new LinkedList<Vertex>();
        q.add(start);
        start.dist = 0;

        while(!q.isEmpty()) {
            Vertex v = q.remove();

            for(Edge e : v.adj) {
                Vertex w = e.dest;

                if( w.dist == INFINITY) {
                    w.dist = v.dist+1;
                    w.prev = v;
                    q.add(w);
                }
            }
        }
    }

    public void dijkstra(String startName) {
        PriorityQueue<Path> pq = new PriorityQueue<Path>();

        Vertex start = vertexMap.get(startName);
        if(start == null) {
            throw new NoSuchElementException();
        }

        clearAll();
        pq.add(new Path(start,0));
        start.dist = 0;

        int nodesSeen = 0;
        while (!pq.isEmpty() && nodesSeen < vertexMap.size()) {
            Path vrec = pq.remove();
            Vertex v = vrec.dest;
            if(v.scratch != 0) {
                continue;
            }

            v.scratch =1;
            nodesSeen++;

            for(Edge e : v.adj) {
                Vertex w = e.dest;
                double cvw = e.cost;

                if (cvw < 0) {
                    throw new GraphException("Graph has negative edges");
                }

                if (w.dist > v.dist + cvw) {
                    w.dist = v.dist + cvw;
                    w.prev = v;
                    pq.add(new Path(w, w.dist));
                }
            }
        }
    }

    private Vertex getVertex(String vertexName) {
        Vertex v = vertexMap.get(vertexName);
        if(v==null) {
            v = new Vertex(vertexName);
            vertexMap.put(vertexName, v);
        }
        return v;
    }

    private void printPath(Vertex dest) {
        if(dest.prev != null) {
            printPath(dest.prev);
            System.out.println(" to ");
        }
        System.out.println(dest.name);
    }

    private void clearAll() {
        for(Vertex v : vertexMap.values()) {
            v.reset();
        }
    }

    private Map<String,Vertex> vertexMap = new HashMap<String, Vertex>();
}

class GraphException extends RuntimeException {
    public GraphException(String name) {
        super(name);
    }
}
