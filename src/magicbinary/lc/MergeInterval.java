package magicbinary.lc;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MergeInterval {
    public static void main(String[] args) {
        int[][] arr  = {{1,3},{2,6},{8,10},{15,18}};
        int[][] ans =  new MergeInterval().merge(arr);

        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i][0]+ " , " + ans[i][1]);
        }
    }


    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length ==0) return null;
        if(intervals.length ==1) return intervals;

        List<int[]> intervallist = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            intervallist.add(intervals[i]);
        }
        int i=0;
        int operationCount =0;
        int firstarr[] = null;
        int[] secondarr = null;
        int[] temparr = new int[2];
        int totalOperations = intervallist.size()-1;
        while(operationCount<totalOperations && i<=intervallist.size()-2){
            firstarr = intervallist.get(i);
            secondarr = intervallist.get(i+1);
            if(firstarr[1]>= secondarr[0]){
                temparr[0] = firstarr[0];
                temparr[1] = secondarr[1];
                intervallist.remove(i);
                intervallist.remove(i);
                intervallist.add(i, temparr);
            }else{
                i++;
            }
            operationCount++;
        }

        int nasarr[][] = new int[intervallist.size()][2];
        for (int j = 0; j < nasarr.length; j++) {
            nasarr[j] = intervallist.get(j);
        }
        return nasarr;
    }

    void arraylisttester(List<String> list) {
        list.add("a"); list.add("b"); list.add("c"); list.add("d");
        list.remove(0);
    }

}
