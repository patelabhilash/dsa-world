package magicbinary.lc;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//https://leetcode.com/problems/minimum-height-trees/
//TLE

public class Leet6GraphMHT {

    public static void main(String[] args) {
        int[][] edges = { { 3, 0 }, { 3, 1 }, { 3, 2 }, { 3, 4 }, { 5, 4 } };

        new Leet6GraphMHT().findMinHeightTrees(6, edges);
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        List<ArrayList<Integer>> adjlist = IntStream.range(0, n).boxed().map(e -> new ArrayList<Integer>())
                .collect(Collectors.toList());

        for (int[] e : edges) {
            adjlist.get(e[0]).add(e[1]);
            adjlist.get(e[1]).add(e[0]);
        }

        boolean[] visitArr;
        int min = Integer.MAX_VALUE;
        int tempheight = 0;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            visitArr = new boolean[n];
            tempheight = dfs(adjlist, visitArr, i);
            System.out.println("tempheight:\t" + tempheight);
            if (tempheight < min) {
                min = tempheight;
                ans.clear();
            }
            if (tempheight == min) {
                ans.add(i);
            }
        }

        return ans;
    }

    int dfs(List<ArrayList<Integer>> adjlist, boolean[] visitArr, int source) {
        visitArr[source] = true;
        int height = 0;

        for (int i = 0; i < adjlist.get(source).size(); i++) {
            if (!visitArr[adjlist.get(source).get(i)]) {
                height = Math.max(height, 1 + dfs(adjlist, visitArr, adjlist.get(source).get(i)));
            }
        }
        return height;
    }

    public int maxValue(int n, int index, int maxSum) {
        maxSum = maxSum - n;
        int i,left,right,leftDeduct, rightDeduct, totalLayerPoint;
        if (maxSum < 0)
            return -1;

        for (i = 1; maxSum > 0; i++) {
            left = i - 1;
            right = i + 1;
            leftDeduct = (index - left < 0) ? left - index : 0;
            rightDeduct = (index + right > n - 1) ? n - 1 - (right + index) : 0;
            totalLayerPoint = 2 * i - 1 - leftDeduct - rightDeduct;
            maxSum -= totalLayerPoint;
        }

        if (maxSum == 0)
            return i;
        if (maxSum < 0)
            return i - 1;
        return -1;
    }
}
