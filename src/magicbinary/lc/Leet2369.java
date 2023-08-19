package magicbinary.lc;

import java.util.stream.IntStream;

public class Leet2369 {
    public boolean validPartition(int[] nums) {
        if (nums == null || nums.length < 2)
            return false;
        // int[] validPartitionGrid = IntStream.range(0, nums.length).map(e -> -1).toArray();
        Boolean[] validPartitionGrid = new Boolean[nums.length];
        return validPartition(nums, 0, validPartitionGrid);
    }

    public boolean validPartition(int[] nums, int start, Boolean[] validPartitionGrid) {
        if ((start == nums.length - 2 && path1(nums, start))
                || (start == nums.length - 3 && (path2(nums, start) || path3(nums, start)))){
                    validPartitionGrid[start] = true;
                    return true;
                }
        if (start > nums.length - 2){
            validPartitionGrid[start] = false;
            return false;
        }

        if(validPartitionGrid[start]!= null) return validPartitionGrid[start];
        validPartitionGrid[start] = (path1(nums, start) && validPartition(nums, start + 2, validPartitionGrid))
        || (path2(nums, start) && validPartition(nums, start + 3, validPartitionGrid))
        || (path3(nums, start) && validPartition(nums, start + 3, validPartitionGrid));
        return validPartitionGrid[start];
    }

    private boolean path1(int[] nums, int start) {
        if (start > nums.length - 2)
            return false;
        return nums[start] == nums[start + 1];
    }

    private boolean path2(int[] nums, int start) {
        if (start > nums.length - 3)
            return false;
        return nums[start] == nums[start + 1] && nums[start + 1] == nums[start + 2];
    }

    private boolean path3(int[] nums, int start) {
        if (start > nums.length - 3)
            return false;
        return nums[start] + 1 == nums[start + 1] && nums[start + 1] + 1 == nums[start + 2];
    }
}
