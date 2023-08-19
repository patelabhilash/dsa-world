package magicbinary.scaler;

public class Day21Q5 {

    public int solve(String A) {
        if (A == null || A.length() == 0)
            return 0;
        int[] lpsArr = getLpsArray(A);
        if (test(A, A.length() - lpsArr[A.length() - 1])) {
            return A.length() - lpsArr[A.length() - 1];
        } else {
            return A.length();
        }
    }

    private boolean test(String A, int k) {
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != A.charAt(i % k)) {
                return false;
            }
        }
        return true;
    }

    int[] getLpsArray(String A) {
        int i = 1;
        int len = 0;
        int[] lpsArr = new int[A.length()];

        while (i < lpsArr.length) {
            if (A.charAt(i) == A.charAt(len)) {
                len++;
                lpsArr[i] = len;
                i++;
            } else {
                if (len == 0) {
                    lpsArr[i] = 0;
                    i++;
                } else {
                    len = lpsArr[len - 1];
                }
            }
        }
        return lpsArr;
    }

    public static void main(String[] args) {
        Day21Q5 day21q5 = new Day21Q5();
        String pat2 = "abcaabcaabcaabca";
        String pat = "axfhy";
        int[] lpsArr = day21q5.getLpsArray(pat);
        System.out.println(day21q5.solve(pat2));
        // Arrays.stream(lpsArr).forEach(System.out::println);
    }
}
