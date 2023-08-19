package magicbinary.lc;

import java.util.List;

/**
 * Graph4DFSmine
 */
public class Graph4DFSmine {

    public static void main(String[] args) {
        Graph graph = new Graph(5);

    }
}

class Graph{
    int capacity;
    List<List<Vertex>> adjlist;
    
    public Graph(int capacity) {
        this.capacity = capacity;
    }

    void addVertex(Vertex v){

    }

    void addEdge(Vertex v1, Vertex v2){
        // adjlist.
    }
    
}

class Vertex{
    boolean isVisited;
    int value;
    int pos;
}