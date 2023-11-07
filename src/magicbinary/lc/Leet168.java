package magicbinary.lc;

import java.util.stream.IntStream;

public class Leet168 {
    public String convertToTitle(int columnNumber) {
        StringBuilder strb = new StringBuilder();
        char c = 'A';
        char d;
        while (columnNumber > 0) {
            columnNumber--;
            d = (char) (columnNumber % 26 + c);
            strb.insert(0, d);
            columnNumber = columnNumber / 26;
        }
        return strb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Leet168().convertToTitle(701));
    }

    // 1572
    public int diagonalSum(int[][] mat) {
        if (mat == null)
            return 0;
        int sum = IntStream.range(0, mat.length).map(i -> mat[i][i] + mat[mat.length - 1 - i][i]).sum();
        if (mat.length % 2 != 0) {
            sum -= mat[mat.length / 2][mat.length / 2];
        }
        return sum;
    }

}
