package magicbinary.lc;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;

public class Graph2BFS {
    
}


class Graph {

    List<List<Integer>> graph;
    boolean visited[];

    Graph(int capacity){
        this.graph = new ArrayList<>();
        visited = new boolean[capacity];

        IntStream.range(0, capacity).forEach(x -> graph.add(new ArrayList<>()));
    }

    public void addEdge(int a, int b){
        graph.get(b).add(a);
        graph.get(a).add(a);
    }

    public void bfs(int startIndex){
        
    }
    
}

class Vertex{
    boolean isVisited;
    int value;
    public Vertex(boolean isVisited, int value) {
        this.isVisited = isVisited;
        this.value = value;
    }


    
}


