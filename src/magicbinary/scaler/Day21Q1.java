package magicbinary.scaler;

public class Day21Q1 {
    public String longestCommonPrefix(String[] A) {
        if(A == null || A.length == 0) return "";
        if(A.length ==1) return A[0];
        int minSize = Integer.MAX_VALUE;
        int minPos = 0;
        for (int i = 0; i < A.length; i++) {
            if(A[i] == null || A.length == 0) return "";
            if(A[i].length()< minSize) {
                minSize = A[i].length();
                minPos = i;
            }
        }

        StringBuilder strb = new StringBuilder();

        
        for (int i = 0; i < minSize; i++) {
            for (int j = 1; j < A.length; j++) {
                if(A[j].charAt(i) != A[j-1].charAt(i)){
                    return strb.toString();
                }
            }
            strb.append(A[0].charAt(i));
        }
        return A[minPos];
    }

    public static void main(String[] args) {
        String[] strs = {"abcd","abde","abcf"}; 
        Day21Q1 day21q1 = new Day21Q1();
        System.out.println(day21q1.longestCommonPrefix(strs));
    }

}
