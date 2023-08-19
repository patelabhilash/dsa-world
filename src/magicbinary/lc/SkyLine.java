package magicbinary.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class SkyLine {

    public static void main(String[] args) {

    }

    // s1 e1 s2 e2 => as it is
    // s1 s2 e1 e2 & h1 > h2
    // s1 s2 e1 e2 & h2 > h1

    // s1 s2 e2 e1 & h1 > h2 => remove e2
    // s1 s2 e2 e1 & h2 > h1 =>

    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> sortedpointlist = new ArrayList<List<Integer>>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        Map<Integer, Integer> silhouettemap = new TreeMap<Integer, Integer>();
        for (int i = 0; i < buildings.length; i++) {
            silhouettemap.put(buildings[i][0],
                    Math.max(silhouettemap.getOrDefault(buildings[i][0], 0), buildings[i][2]));
            silhouettemap.put(buildings[i][1],
                    Math.max(silhouettemap.getOrDefault(buildings[i][1], -buildings[i][2]), -buildings[i][2]));
        }

        silhouettemap.forEach((k, v) -> sortedpointlist.add(new ArrayList<>(Arrays.asList(k, v))));

        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>(Collections.reverseOrder());

        int temp = 0;
        pQueue.add(0);
        for (int i = 0; i < sortedpointlist.size(); i++) {
            temp = sortedpointlist.get(i).get(1);
            if(pQueue.peek() > temp && temp > 0){
                continue;
            }
            if(temp < 0){
                 pQueue.remove(-temp); // removes the corresponding height element from the queue
                ans.add(new ArrayList<>(Arrays.asList(sortedpointlist.get(i).get(0), pQueue.peek())));
            }else{
                ans.add(new ArrayList<>(Arrays.asList(sortedpointlist.get(i).get(0),0)));
            }
        }
        
        return ans;
    }
}
