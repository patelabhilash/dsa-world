package magicbinary.lc;

public class Leet1351 {
    public int countNegatives(int[][] grid) {
        int nonNegativeCount = 0;
        int currNonNegative = grid[0].length - 1;

        for (int i = 0; i < grid.length; i++) {
            currNonNegative = getlastNonNegativeIndex(grid, i, currNonNegative);
            nonNegativeCount += currNonNegative + 1;
        }
        return grid.length * grid[0].length - nonNegativeCount;
    }

    int getlastNonNegativeIndex(int[][] grid, int rowNumber, int rightBorder) {
        if(grid[rowNumber][0]<0) return -1;
        int low = 0;
        int high = rightBorder;
        int mid = (low + high) / 2;
        while (low <= high) {
            if (grid[rowNumber][mid] >= 0)
                low = mid + 1;
            else
                high = mid - 1;
            mid = (low + high) / 2;
        }
        return mid;
    }

    public static void main(String[] args) {
        int[][] testgrid = { { 4, 3, 2, -1 },
                { 3, 2, 1, -1 },
                { 1, -1, -1, -2 },
                { -1, -1, -2, -3 }
        };
        int[][] testgrid2 = {{5,1,0},{-5,-5,-5}};

        System.out.println(new Leet1351().countNegatives(testgrid2));
    }
}
