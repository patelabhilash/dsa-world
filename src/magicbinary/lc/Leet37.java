package magicbinary.lc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Leet37 {

    public void solveSudoku(char[][] board) {
        HashSet<Character>[][] setarr = new HashSet[3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 3; j++) {
                setarr[j][i] = new HashSet<Character>();
            }
        }

        // boolean[][] isFree = new boolean[9][9];

        ArrayList<Character>[][] availableList = new ArrayList[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                availableList[i][j] = new ArrayList<Character>();
                setarr[0][i].add(board[i][j]);
                setarr[1][j].add(board[i][j]);
                setarr[2][3 * (i / 3) + (j / 3)].add(board[i][j]);
            }
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(availableList[i][j]!= null){
                    for (int k = 0; k < 9; k++) {
                        if(canFit(i,j,k, setarr)){
                            availableList[i][j].add((char)k); // may be odd 
                        }
                    }
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

            }
        }

        if(availableList[0][0]!= null){
            isValidSudoku(0, 0, availableList, board, setarr);
        }else{
            int nextPos[] = getNextPos(0,0,availableList);
            if (nextPos ==  null) return;
            else isValidSudoku(nextPos[0], nextPos[1], availableList, board,setarr );
        }
    }

    //TODO
    boolean isValidSudoku(int i, int j, ArrayList<Character>[][] availableList, char[][] board, Set<Character>[][] setarr){
        int nextPos[] = getNextPos(i,j,availableList);
        if(nextPos == null){
            for(int k=0;k<availableList[i][j].size(); k++){
                if(canFit(i, j, availableList[i][j].get(k), setarr)){
                    doFit(i, i, availableList[i][j].get(k), setarr, board);
                }
            }
            return true;
        }
        while(nextPos != null){
            for(int k=0;k<availableList[i][j].size(); k++){
                if(canFit(i, j, availableList[i][j].get(k), setarr)){
                    doFit(i, i, availableList[i][j].get(k), setarr, board);
                    isValidSudoku(nextPos[0], nextPos[1], availableList, board, setarr);
                }
                removeFit(i, j, availableList[i][j].get(k), setarr, board);
            }
        }
        return false;
    }

    private boolean canFit(int i, int j, int k, Set<Character>[][] setarr) {
        if(setarr[0][i].contains(k) || setarr[1][j].contains(k) || setarr[2][3*(i/3)+(j/3)].contains(k)) return false;
        return true;
    }

    private void doFit(int i, int j, char k, Set<Character>[][] setarr, char[][] board){
        setarr[0][i].add(k);
        setarr[1][j].add(k);
        setarr[2][3*(i/3)+(j/3)].add(k);
        board[i][j] = k;
    }

    private void removeFit(int i, int j, char k, Set<Character>[][] setarr, char[][] board){
        setarr[0][i].remove(k);
        setarr[1][j].remove(k);
        setarr[2][3*(i/3)+(j/3)].remove(k);
    }

    private int[] getNextPos(int ix, int jx, ArrayList<Character>[][] availableList){
        int[] nextpos = new int[2];
        for(;ix<9;ix++){
            for (jx = jx+1; jx < 9; jx++) {
                if(availableList[ix][jx]!= null){
                    nextpos[0] = ix; nextpos[1] = jx;
                    return nextpos;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
