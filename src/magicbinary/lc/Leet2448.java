package magicbinary.lc;

import java.math.BigInteger;
import java.util.HashMap;

public class Leet2448 {

    public long minCost2(int[] nums, int[] cost) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i : nums) {
            if (i < min)
                min = i;
            if (i > max)
                max = i;
        }
        BigInteger minCost = BigInteger.valueOf(Long.MAX_VALUE);
        BigInteger tempCost = BigInteger.valueOf(0);
        for (int i = min; i < max + 1; i++) {
            tempCost = BigInteger.valueOf(0);
            for (int j = 0; j < nums.length; j++) {
                if (tempCost.compareTo(minCost) > 0) {
                    break;
                }
                tempCost = tempCost.add(BigInteger.valueOf(Math.abs(i - nums[j]) * cost[j]));
                if(tempCost.longValue()<0){
                    System.out.println(i);
                    return tempCost.longValue();
                }
            }
            if (tempCost.longValue()>=0 && tempCost.compareTo(minCost) < 0) {
                minCost = tempCost;
            }
            
        }
        return minCost.longValue();
    }


    public long minCost(int[] nums, int[] cost) {
        return 0;

    }

    
    public static void main(String[] args) {
        int[] nums = { 735103, 366367, 132236, 133334, 808160, 113001, 49051, 735598, 686615, 665317, 999793, 426087,
                587000, 649989, 509946, 743518 };

        int[] costs = { 724182, 447415, 723725, 902336, 600863, 287644, 13836, 665183, 448859, 917248, 397790, 898215,
                790754, 320604, 468575, 825614 };
        System.out.println(new Leet2448().minCost(nums, costs));
    }
}
