//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
package magicbinary.lc;

import java.util.Arrays;

public class Leet2 {

    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        if(nums == null) return ans;
        int left = Arrays.binarySearch(nums, target);
        if(left < 0) return ans;
        int foundval = left;
        int right = left;
        
        while(foundval-1 >= 0 && nums[foundval-1] == target){
            foundval--;
        }
        while(right+1<nums.length && nums[right+1] == target){
            right++;
        }
        ans[0] = foundval; ans[1] =  right;
        return ans;
    }
}
