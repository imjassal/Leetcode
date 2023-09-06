import java.util.*;
public class Leetcode_36 {
    public static void main(String[] args) {
        char[][] board =
                       {{'.','.','.','.','5','.','.','1','.'},
                        {'.','4','.','3','.','.','.','.','.'},
                        {'.','.','.','.','.','3','.','.','1'},
                        {'8','.','.','.','.','.','.','2','.'},
                        {'.','.','2','.','7','.','.','.','.'},
                        {'.','1','5','.','.','.','.','.','.'},
                        {'.','.','.','.','.','2','.','.','.'},
                        {'.','2','.','9','.','.','.','.','.'},
                        {'.','.','4','.','.','.','.','.','.'}};
        System.out.print(isValidSudoku(board));
    }
    public static boolean isValidSudoku(char[][] board) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<board.length;i++){
            set = new HashSet<>();
            for(int j=0;j<9;j++){
                if(board[i][j]!='.') {
                    boolean ans = set.add(board[i][j] - 'a');
                    if(!ans)
                        return ans;
                }
            }
        }
        for(int i=0;i<board.length;i++){
            set = new HashSet<>();
            for(int j=0;j<9;j++){
                if(board[j][i]!='.') {
                    boolean ans = set.add(board[j][i] - 'a');
                    if(!ans)
                        return ans;
                }
            }
        }
        for(int i=0;i<3;i++) {
            for (int j = 0; j < 3; j++) {
                set = new HashSet<>();
                for (int p = 3 * i; p < 3 * i + 3; p++) {
                    for (int q = 3 * j; q < 3 * j + 3; q++) {
                        if (board[p][q] != '.') {
                            boolean ans = set.add(board[p][q] - 'a');
                            if (!ans)
                                return ans;
                        }
                    }
                }
            }
        }
        return true;
    }
}
