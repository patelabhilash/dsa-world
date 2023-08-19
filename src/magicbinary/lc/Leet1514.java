package magicbinary.lc;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Leet1514 {
    static double ultimateProbability = 0;

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        if (n == 0 || edges == null || edges.length == 0)
            return 0;

        List<ArrayList<Integer>> adjlist = IntStream.range(0, n).boxed().map(x -> new ArrayList<Integer>())
                .collect(Collectors.toList());
        List<ArrayList<Double>> succlist = IntStream.range(0, n).boxed().map(x -> new ArrayList<Double>())
                .collect(Collectors.toList());
        for (int i = 0; i < edges.length; i++) {
            adjlist.get(edges[i][0]).add(edges[i][1]);
            succlist.get(edges[i][0]).add(succProb[i]);
            adjlist.get(edges[i][1]).add(edges[i][0]);
            succlist.get(edges[i][1]).add(succProb[i]);
        }
        boolean visitedArr[] = new boolean[n];

        dfsProbability(adjlist, start, end, 1, succlist, visitedArr);
        double ans = ultimateProbability;
        ultimateProbability = 0;
        return ans;
    }

    double dfsProbability(List<ArrayList<Integer>> adjlist, int start, int end, double probability,
            List<ArrayList<Double>> succlist, boolean[] visitedArr) {
        double earlierprob = probability;
        if (start == end) {
            ultimateProbability = Math.max(probability, ultimateProbability);
            return probability;
        }

        visitedArr[start] = true;

        for (int i = 0; i < adjlist.get(start).size() && probability > ultimateProbability; i++) {
            if (!visitedArr[adjlist.get(start).get(i)]) {
                earlierprob = succlist.get(start).get(i) * probability;
                if (earlierprob > ultimateProbability)
                    dfsProbability(adjlist, adjlist.get(start).get(i), end, earlierprob, succlist, visitedArr);
            }
        }
        visitedArr[start] = false;

        return probability;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] edges = { { 0, 1 }, { 1, 2 }, { 0, 2 } };
        double[] succProb = { 0.5, 0.5, 0.3 };
        int start = 0, end = 2;
        double ans1 = new Leet1514().maxProbability(n, edges, succProb, start, end);

        double ans2 = new Leet1514().maxProbability(n, new int[][] { { 0, 1 } }, new double[] { 0.5 }, start, end);
        System.out.println(ans1);
    }
}
