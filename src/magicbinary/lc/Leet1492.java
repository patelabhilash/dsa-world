package magicbinary.lc;

import java.util.ArrayList;

public class Leet1492 {
    public int kthFactor(int n, int k) {
        int sqrt = (int) Math.sqrt(n);
        ArrayList<Integer> factorList = new ArrayList<>();
        if (n == 2 || n == 3) {
            factorList.add(1);
            factorList.add(n);
        } else {
            int count = 0;
            for (int i = 1; i <= sqrt; i++) {
                if (n % i == 0) {
                    factorList.add(count, i);
                    if(!(i==sqrt && n== sqrt *sqrt))factorList.add(factorList.size() - count, n / i);
                    count++;
                    if (count == k) {
                        return factorList.get(k - 1);
                    }
                }
            }
        }
        if (k <= factorList.size()) {
            return factorList.get(k - 1);
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Leet1492().kthFactor(24, 6));
        //1,2,3,4, 6,8,12,24
    }
}
