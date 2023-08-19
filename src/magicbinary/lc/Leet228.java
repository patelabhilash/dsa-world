package magicbinary.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leet228 {
    public List<String> summaryRanges(int[] nums) {
        int tempStart = nums[0];
        StringBuilder strb = new StringBuilder();
        String arrowstr = "->";
        int tempEnd;
        int i = 1;
        List<String> rangelist = new ArrayList<String>();
        while (i < nums.length) {
            tempEnd = nums[i];
            if (nums[i] != nums[i - 1]+1) {
                if (tempStart == tempEnd) {
                    strb.append(tempStart);
                    rangelist.add(strb.toString());
                    strb.setLength(0);
                } else {
                    strb.append(tempStart);
                    strb.append(arrowstr);
                    strb.append(tempEnd);
                    rangelist.add(strb.toString());
                    strb.setLength(0);
                }
                tempStart = nums[i];
            }
            i++;
        }
        return rangelist;
    }


    public List<String> summaryRanges2(int[] nums) {
        if(nums.length == 0) return new ArrayList<String>();
        if(nums.length == 1) return new ArrayList<String>(Arrays.asList(nums[0]+""));
        int start = nums[0];
        String arrowstr = "->";

        List<String> rangelist = new ArrayList<String>();
        for(int i=1;i< nums.length; i++){
            if(nums[i]!=nums[i-1]+1){
                print(start, nums[i-1], rangelist, arrowstr);
                start = nums[i];
            }
            if(i == nums.length -1){
                print(start, nums[i], rangelist, arrowstr);
            }
        }
        return rangelist;
    }

    void print(int start, int end, List<String> rangelist, String arrowstr){
        if(start!=end)
        rangelist.add(start + arrowstr + end);
        else
        rangelist.add(start+"");
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,4,5,6};
        new Leet228().summaryRanges2(nums).forEach(System.out::println);
    }
}
