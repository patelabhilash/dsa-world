package magicbinary.lc;

public class Leet14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        for (String s : strs) {
            if (s == null || s.length() == 0)
                return "";
        }
        if (strs.length == 1)
            return strs[0];
        int i = 0;
        StringBuilder lcp = new StringBuilder();
        while (i < strs[0].length()) {
            for (int j = 1; j < strs.length; j++) {
                if ((i >= strs[j].length()) || (strs[j].charAt(i) != strs[j - 1].charAt(i))) {
                    return lcp.toString();
                }
            }
            lcp.append(strs[0].charAt(i));
            i++;
        }
        return lcp.toString();
    }

    public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 1) return;
        int[][] rotatedMatrix = new int[matrix.length][matrix.length];
        for(int i=0;i< matrix.length; i++){
            for(int j=0;j< matrix.length; j++){
                rotatedMatrix[i][j] = matrix[matrix.length-1-j][i];
            }
        }

        for(int i=0;i< matrix.length; i++){
            for(int j=0;j< matrix.length; j++){
                matrix[i][j] = rotatedMatrix[i][j];
            }
        }
    }

    public static void main(String[] args) {
        String[] strs = { "a", "ac" };
        System.out.println(new Leet14().longestCommonPrefix(strs));
    }
}
