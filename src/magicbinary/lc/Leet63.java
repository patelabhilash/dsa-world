package magicbinary.lc;

public class Leet63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0) return 0;
        if ( obstacleGrid[0][0] == 1) return 0;
        int[][] uniquePathsWithObstacleGrid = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < uniquePathsWithObstacleGrid.length; i++) {
            for (int j = 0; j < uniquePathsWithObstacleGrid[0].length; j++) {
                uniquePathsWithObstacleGrid[i][j] = -1;
            }
        }
        uniquePathsWithObstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1] = -1;
        return  uniquePathsWithObstacles(obstacleGrid,0,0, uniquePathsWithObstacleGrid);
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid, int myx, int myy , int[][] uniquePathsWithObstacleGrid) {
        if(myx == obstacleGrid.length-1 && myy == obstacleGrid[0].length-1) {     
            return 1;
        }
        int xpoint=0,ypoint=0;
        if( myx<obstacleGrid.length-1 && obstacleGrid[myx+1][myy]!=1){
            xpoint = (uniquePathsWithObstacleGrid[myx+1][myy] == -1)? uniquePathsWithObstacles(obstacleGrid,myx+1, myy, uniquePathsWithObstacleGrid): uniquePathsWithObstacleGrid[myx+1][myy];
        }
        if(myy<obstacleGrid[0].length-1 && obstacleGrid[myx][myy+1]!=1){
            ypoint = (uniquePathsWithObstacleGrid[myx][myy+1] == -1)? uniquePathsWithObstacles(obstacleGrid,myx,myy+1, uniquePathsWithObstacleGrid): uniquePathsWithObstacleGrid[myx][myy+1];
        }
        uniquePathsWithObstacleGrid[myx][myy] = xpoint+ypoint;
        return xpoint+ypoint;
    }
}
