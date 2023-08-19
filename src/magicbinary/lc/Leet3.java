//https://leetcode.com/problems/find-if-path-exists-in-graph/

// memory limit exceeded
package magicbinary.lc;

import java.util.ArrayDeque;
import java.util.Deque;

public class Leet3 {
    
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(n== 0 || edges == null || edges.length ==0) return false;
        Deque<Integer> deque = new ArrayDeque<>();
        boolean[] visitedArr = new boolean[n];
        boolean[][] adjMat  = genAdjMat(n, edges, deque, source);
        while(!deque.isEmpty()){
            int poppedVert = deque.pop();
            visitedArr[poppedVert] = false;

            for(int i=0;i<n;i++){
                if(adjMat[poppedVert][i] && !visitedArr[i]){
                    if(i == destination) return true;
                    deque.push(i);
                }
            }
           
        }
    return false;
    }

    boolean[][] genAdjMat(int n, int[][] edges, Deque<Integer> deque, int source){
        boolean[][] adjMat = new boolean[n][n];
        for(int i=0;i<edges.length;i++){
            adjMat[edges[i][0]][edges[i][1]] = true;
            adjMat[edges[i][1]][edges[i][0]] = true;
            if(edges[i][0] == source){
                deque.push(edges[i][1]);
            }
            if(edges[i][1] == source){
                deque.push(edges[i][0]);
            }
        }
        return adjMat;
    }
}
