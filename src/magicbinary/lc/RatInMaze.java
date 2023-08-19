package magicbinary.lc;

public class RatInMaze {

    public static void main(String[] args) {
        int maze[][] = { { 1, 0, 0, 0 },
                { 1, 1, 1, 0 },
                { 1, 0, 1, 1 },
                { 0, 0, 0, 1 }
        };
        new RatInMaze().printMazePath(maze);
    }

    private void printMazePath(int[][] maze) {
        int[][] path = new int[maze.length][maze[0].length];
        boolean doesPathExist = printMazePath(maze, 0, 0, path);

        if(doesPathExist){
            printPath(path);
        }else{
            System.out.println("path does not exist");
        }
    }

    private void printPath(int[][] path) {
        for (int i = 0; i < path.length; i++) {
            for (int j = 0; j < path.length; j++) {
               System.out.print(path[i][j] + "\t"); 
            }
            System.out.println();
        }
    }

    private boolean printMazePath(int[][] maze, int i, int j, int[][] path) {
        path[i][j] = 1;
        if(i== maze.length-1 && i == maze.length-1){
            return true;
        }
        /* if(canMoveRight()){
            movedrightcall
        }
         */
        return false;
    }
}
