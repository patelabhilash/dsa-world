package magicbinary.lc;
//https://leetcode.com/problems/find-the-town-judge/
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Leet5Graph {

    public static void main(String[] args) {
        int[][] l= {{1,2},{2,1}};
        int ans = new Leet5Graph().findJudge(2,l );
        System.out.println(ans);
    }

    public int findJudge(int n, int[][] trust) {
        if(trust == null || n == 0) return -1;
        if(n ==1 && trust.length == 0) return 1;
        if(trust.length ==0 ) return -1;
        List<HashSet<Integer>> list = IntStream.range(0, n).boxed().map(e -> new HashSet<Integer>())
                .collect(Collectors.toList());

        for (int i = 0; i < trust.length; i++) {
            trust[i][0] -= 1;
            trust[i][1] -= 1;
            list.get(trust[i][1]).add(trust[i][0]);
        }

        for (int i = 0; i < n; i++) {
            if (list.get(i).size() == n - 1 && !list.get(i).contains(i)) {
                for(int j=0;j<n; j++){
                    if(list.get(j).contains(i)) return -1;
                }
                return i + 1;
            }
        }

        return -1;

    }
}
