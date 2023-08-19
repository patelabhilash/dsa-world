package magicbinary.lc;

public class Leet1318 {
    public int minFlips(int a, int b, int c) {
        String A  = Integer.toBinaryString(a);
        String B  = Integer.toBinaryString(b);
        String C  = Integer.toBinaryString(c);
        String AORC = Integer.toBinaryString(a | b);
        System.out.println(A.length() +"\t"+ B.length() +"\t"+ C.length() +"\t"+ AORC.length());
        System.out.println(A +"\t"+ B +"\t"+ C +"\t"+ AORC);
        int minlength = Math.min(Math.min(Math.min(A.length(), B.length()), C.length()), AORC.length());
        return 0;
    }

    public static void main(String[] args) {
        new Leet1318().minFlips(5, 0, 999999);
    }
}
