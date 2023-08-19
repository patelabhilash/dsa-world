package magicbinary.lc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class AtheleteRanking {
    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((Comparator.comparing(x -> -score[x])));
        IntStream.range(0, score.length).forEach(e -> pq.add(e));
        String[] ans = new String[score.length];
        for (int i = 0; i < score.length; i++) {
            ans[pq.poll()] = i+1 +"";
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] scores = { 10,3,8,9,4 };
        String[] ranks = new AtheleteRanking().findRelativeRanks(scores);
        System.out.println("Ranks: " + Arrays.toString(ranks));
    }
}