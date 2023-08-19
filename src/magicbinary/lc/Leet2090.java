package magicbinary.lc;
import java.util.Arrays;

public class Leet2090 {
    public int[] getAverages(int[] nums, int k) {
        int[] avgs = new int[nums.length];
        if (nums == null || nums.length == 0 || k == 0)
            return nums;
        if ((nums.length%2 == 0)? k > nums.length / 2: k >= nums.length / 2) {
            Arrays.fill(avgs, -1);
            return avgs;
        }
        long sum = 0;
        int div = 2 * k + 1;
        for (int i = 0; i < 2 * k + 1; i++) {
            sum += nums[i];
        }
        System.out.println(sum);

        for (int i = 0; i < avgs.length; i++) {
            if (i < k || i>= avgs.length - k ) {
                avgs[i] = -1;
            } else if (i == k) {
                avgs[i] = (int)(sum / div);
            } else {
                sum = sum - nums[i - k - 1] + nums[i + k];
                System.out.println(sum);
                avgs[i] = (int)(sum / div);
            }
        }

        return avgs;

    }

    public static void main(String[] args) {
        int[] nums = {7,4,3,9,1,8,5,2,6};
        int[] nums2 = {2,2,1};
        System.err.println();
        for (int i : new Leet2090().getAverages(nums2, 1)) {
            System.out.println(i);
        };
    }
}
