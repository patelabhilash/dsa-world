package magicbinary.lc;

import java.util.Arrays;

/**
 * PivotChecker
 */
public class PivotChecker {

    public static void main(String[] args) {
        
    }

    int getPivotIndex(int[] nums){
        if(nums == null || nums.length == 0 || nums.length ==2 ) return -1;
        if(nums.length == 1) return 0;
        int i=0;
        int j= nums.length -1;
        int leftsum =0;
        int rightsum =0;


        while(i<=j){
            if(leftsum + nums[i] > rightsum + nums[j]){
                rightsum = rightsum + nums[j];
                j--;
            }

            if(leftsum + nums[i] < rightsum + nums[j]){
                leftsum = leftsum + nums[i];
                i++;
            }

            if(leftsum + nums[i] == rightsum + nums[j] && i<j){
                leftsum = leftsum + nums[i];
                i++;
            }

            if(leftsum + nums[i] == rightsum + nums[j] && i==j){
                return i;
            }

        }
        return -1;
    }

}