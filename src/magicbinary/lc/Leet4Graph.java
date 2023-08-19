//https://leetcode.com/problems/find-if-path-exists-in-graph/

package magicbinary.lc;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

public class Leet4Graph {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (n == 0 || edges == null || edges.length == 0)
            return false;
        Deque<Integer> deque = new ArrayDeque<>();
        boolean[] visitedArr = new boolean[n];
        List<int[]> edgelist = Arrays.stream(edges).collect(Collectors.toList());
        edgelist.forEach( e -> {
            if(e[0] == source) deque.offer(e[1]);if(e[1] == source) deque.offer(e[0]);
        });
        while(!deque.isEmpty()){
            int poppedVert = deque.pop();
            visitedArr[poppedVert] = true;
            
        }
        return false;
    }
}
