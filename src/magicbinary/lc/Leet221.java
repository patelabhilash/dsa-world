package magicbinary.lc;

public class Leet221 {
    public int maximalSquare(char[][] matrix) {
        int maxArea = 0;
        int currArea = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    currArea = getcurrentArea(i, j, matrix);
                    if (currArea > maxArea)
                        maxArea = currArea;
                }
            }
        }
        return maxArea;
    }

    private int getcurrentArea(int i, int j, char[][] mat) {
        if (i == mat.length - 1 || j == mat[0].length - 1)
            return 1;

        int k = 1;
        for (k = 1; (k + i) < mat.length && (k + j) < mat[0].length; k++) {
            for (int ik = 0; ik <= k && (i + ik) < mat.length && (j + ik) < mat[0].length; ik++) {
                System.out.println(k);
                System.out.println(  "[" + (i + ik) + "]["+ (j + k)+ "]" + "\t" +  "[" + (i + k) +"][" + (j + ik) +"]");
                if (mat[i + ik][j + k] == '0' || mat[i + k][j + ik] == '0')
                return k * k;
            }
        }
        return k*k;
    }

    public static void main(String[] args) {
        char[][] inputarr = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        char[][] inputarr2 = {{'1','1'},{'1','1'}};
        System.out.println(new Leet221().maximalSquare(inputarr));
    }
}
