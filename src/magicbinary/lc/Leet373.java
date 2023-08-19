package magicbinary.lc;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Leet373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> smallestSumList = new ArrayList<>(new ArrayList<>());
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0 || k == 0)
            return smallestSumList;
        PriorityQueue<Sum> pq = new PriorityQueue<>(Comparator.comparing(a -> (a.i+a.j)));
        int ik =0;
        int icount = 0, jcount = 0;
        while(ik<k){
            if(icount == nums1.length-1 && jcount == nums2.length-1){
                break;
            }
            if(icount == nums1.length-1) jcount++;
            else if(jcount == nums2.length-1) icount++;
            else{
                if(nums1[icount] < nums2[jcount]){
                    icount++;
                }else{
                    jcount++;
                }
            }
            ik++;
        }
        for(int i=0;i<=icount; i++){
            for(int j=0;j<=jcount; j++){
                pq.add(new Sum(nums1[i], nums2[j]));
            }
        }
        Sum tempsum = null;
        for (int i = 0; i < k && !pq.isEmpty(); i++) {
            tempsum = pq.poll();
            smallestSumList.add(new ArrayList<>(Arrays.asList(tempsum.i, tempsum.j)));
        }
        return smallestSumList;
    }

    public List<List<Integer>> kSmallestPairs2(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> smallestSumList = new ArrayList<>(new ArrayList<>());
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0 || k == 0)
            return smallestSumList;
        PriorityQueue<Sum> pq = new PriorityQueue<>(Comparator.comparing(a -> (a.i+a.j)));
        for(int i=0;i<nums1.length && i<k; i++){
            for(int j=0;j<nums2.length && j < k; j++){
                pq.add(new Sum(nums1[i], nums2[j]));
            }
        }
        Sum tempsum = null;
        for (int i = 0; i < k && !pq.isEmpty(); i++) {
            tempsum = pq.poll();
            smallestSumList.add(new ArrayList<>(Arrays.asList(tempsum.i, tempsum.j)));
        }
        return smallestSumList;
    }

    public static void main(String[] args) {
       int[] nums1 = {1,7,11}; int[] nums2 = {2,4,6}; int k = 3;
       Leet373 leet373 = new Leet373();
       leet373.kSmallestPairs2(nums1, nums2, k).forEach(x -> {System.out.println(); x.forEach( y -> System.out.print(y + "\t"));});
    }
}

class Sum{
    public int i;
    public int j;

    public Sum(int i, int j){
        this.i = i;
        this.j = j;
    }
}
