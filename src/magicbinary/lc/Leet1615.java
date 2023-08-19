package magicbinary.lc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class Leet1615 {
    public int maximalNetworkRank2(int n, int[][] roads) {
        if (n < 2)
            return -1;
        int[] cityRanks = new int[n];
        for (int i = 0; i < roads.length; i++) {
            cityRanks[roads[i][0]] = cityRanks[roads[i][0]] + 1;
            cityRanks[roads[i][1]] = cityRanks[roads[i][1]] + 1;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> cityRanks[b] - cityRanks[a]);
        IntStream.range(0, n).forEach(x -> pq.add(x));
        int a = pq.poll(), b = pq.peek();

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < roads.length; i++) {
            if (roads[i][0] == a) {
                set.add(roads[i][1]);
            }
            if (roads[i][1] == a) {
                set.add(roads[i][0]);
            }
        }
        int isFConnected = set.contains(b) ? 1 : 0;
        while (isFConnected == 1 && pq.size() > 0 && cityRanks[pq.peek()] == cityRanks[b]) {
            if (!set.contains(pq.poll())) {
                isFConnected = 0;
            }
        }
        return cityRanks[a] + cityRanks[b] - isFConnected;
    }

    public int maximalNetworkRank(int n, int[][] roads) {
        if (n < 2)
            return -1;
        int[] cityRanks = new int[n];
        boolean isConnected[][] = new boolean[n][n];
        for (int i = 0; i < roads.length; i++) {
            cityRanks[roads[i][0]] = cityRanks[roads[i][0]] + 1;
            cityRanks[roads[i][1]] = cityRanks[roads[i][1]] + 1;
            isConnected[roads[i][0]][roads[i][1]] = true;
            isConnected[roads[i][1]][roads[i][0]] = true;
        }

        int currRank = Integer.MIN_VALUE;
        int maxRank = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if(i!=j){
                    currRank = cityRanks[i] + cityRanks[j] - ((isConnected[i][j])?1:0);
                    if(currRank> maxRank) maxRank = currRank;
                }
            }
        }
        return maxRank;
    }

    public static void main(String[] args) {
        int[][] roads = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 2, 4 }, { 5, 6 }, { 5, 7 } };
        int[][] roads2 = { { 2, 3 }, { 0, 3 }, { 0, 4 }, { 4, 1 } };
        // System.out.println(new Leet1615().maximalNetworkRank(8, roads));
        System.out.println(new Leet1615().maximalNetworkRank(5, roads2));
    }
}
