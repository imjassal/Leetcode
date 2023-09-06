public class Leetcode_2328 {
    private static int[][] matrix;
    private static int rowLength, columnLength;
    private static int[][] dp;
    private static int mod = (int)(1e9+7);
    public static void main(String[] args) {
        int[][] grid = {{1,1},{3,4}};
        System.out.print(countPaths(grid));
    }
    public static int longestIncreasingPath(int row, int col){
        int longestpath = 1;
        if(dp[row][col] > 0){
            return dp[row][col];
        }
        if(row+1 < rowLength && matrix[row+1][col] > matrix[row][col]){
            longestpath = (longestpath + longestIncreasingPath(row+1, col))%mod;
        }

        if(row-1 >= 0 && matrix[row-1][col] > matrix[row][col]){
            longestpath = (longestpath + longestIncreasingPath(row-1, col))%mod;
        }

        if(col+1 < columnLength && matrix[row][col+1] > matrix[row][col]){
            longestpath = (longestpath + longestIncreasingPath(row, col+1))%mod;
        }

        if(col-1 >= 0 && matrix[row][col-1] > matrix[row][col]){
            longestpath = (longestpath + longestIncreasingPath(row, col-1))%mod;
        }

        dp[row][col] = longestpath;
        return longestpath;
    }

    public static int countPaths(int[][] grid) {
        matrix = grid;
        rowLength = matrix.length;
        columnLength = matrix[0].length;
        dp = new int[rowLength][columnLength];

        int ans = 0;
        for(int i = 0; i < rowLength; i++){
            for(int j = 0; j < columnLength; j++){
                ans = (ans + longestIncreasingPath(i, j))%mod;
            }
        }
        return ans;
    }
}
