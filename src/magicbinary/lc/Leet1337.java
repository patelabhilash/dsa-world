package magicbinary.lc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class Leet1337 {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparing(x -> Arrays.stream(mat[(int)x]).sum())
        .thenComparingInt(x -> (int)x));
        IntStream.range(0, mat.length).forEach(x -> pq.add(x));
        return IntStream.range(0,k).map(x -> pq.poll()).toArray();
    }
}
