package magicbinary.lc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Leet703 {

    PriorityQueue<Integer> pq;
    int size;
    
    public KthLargest(int k, int[] nums) {
        this.size = k;
        pq = new PriorityQueue<Integer>(k);
        Arrays.stream(nums).forEach( e-> this.add(e));
    }
    
    public int add(int val) {
        if(pq.size()<this.size) pq.add(val);
        else if(pq.peek()< val){pq.poll(); pq.add(val);}
        return pq.peek();
    }
}
