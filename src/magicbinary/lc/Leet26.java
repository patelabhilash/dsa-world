package magicbinary.lc;

public class Leet26 {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length ==0) return 0;
        if(nums.length ==1) return 1;
        int uniqueCount = 1;
        for(int i=1;i< nums.length; i++){
            if(nums[i]!=nums[i-1]){
                uniqueCount++;
            }
        }
        return uniqueCount;
    }

    public static void main(String[] args) {
        int nums[] = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(new Leet26().removeDuplicates(nums));
        // System.out.println(0.2+0.01);
    }
}
