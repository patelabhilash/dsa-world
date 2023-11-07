package magicbinary.lc;

public class Leet1822 {
    public int arraySign(int[] nums) {
        boolean isNegative = false;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) return 0;
            if(nums[i] < 0 ) isNegative = !isNegative;
        }
        return (isNegative)? -1 : 1;
    }
}
