package magicbinary.lc;

import java.util.HashSet;
import java.util.Set;

public class Leet36 {

    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[][] setarr = new HashSet[3][9];
        for(int i=0;i<9;i++){
            for(int j=0;j<3; j++){
                setarr[j][i] = new HashSet<Character>();
            } 
        }

        for(int i=0; i< 9; i++){
            for(int j=0;j<9 ; j++){
                if(board[i][j] == '.') continue;
                if(setarr[0][i].contains(board[i][j]) || setarr[1][j].contains(board[i][j]) || setarr[2][3*(i/3)+(j/3)].contains(board[i][j])) return false;
                setarr[0][i].add(board[i][j]);
                setarr[1][j].add(board[i][j]);
                setarr[2][3*(i/3)+(j/3)].add(board[i][j]);
            }
        }

        for(int i=0;i<3;i++){
            for(int j=0;j<9; j++){
                setarr[i][j].forEach( k -> System.out.print(k + "\t"));
                System.out.println();
            } 
            System.out.println();
        }

        return true;
    }

    public static void main(String[] args) {
        char[][] board =
        {{'8','3','.','.','7','.','.','.','.'}
        ,{'6','.','.','1','9','5','.','.','.'}
        ,{'.','9','8','.','.','.','.','6','.'}
        ,{'8','.','.','.','6','.','.','.','3'}
        ,{'4','.','.','8','.','3','.','.','1'}
        ,{'7','.','.','.','2','.','.','.','6'}
        ,{'.','6','.','.','.','.','2','8','.'}
        ,{'.','.','.','4','1','9','.','.','5'}
        ,{'.','.','.','.','8','.','.','7','9'}};
        System.out.println(new Leet36().isValidSudoku(board));
    }
}
