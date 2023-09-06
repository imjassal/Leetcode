public class Leetcode_62 {
    public static void main(String[] args) {
        int m =3 ,n = 7;
        System.out.println(uniquePaths(m,n));
    }
    public static int uniquePaths(int m, int n) {
//        int dp[][]=new int[m][n];
//        for(int i=0;i<m;i++){
//            for(int j=0;j<n;j++){
//                dp[i][j]=-1;
//            }
//        }
//        return solve(0,0,m,n,dp);
//    }
//    public static int solve(int i,int j,int m,int n,int dp[][]){
//        if(i>=m || j>=n) return 0;
//        if(i==m-1 && j==n-1) return 1;
//        if(dp[i][j]!=-1) return dp[i][j];
//        else return dp[i][j]=solve(i+1,j,m,n,dp)+solve(i,j+1,m,n,dp);
        int[][] grid = new int[m][n];
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (row == 0 || col == 0) {
                    grid[row][col] = 1;
                }
                else {
                    grid[row][col] = grid[row-1][col] + grid[row][col-1];
                }
            }
        }
        return grid[m-1][n-1];
    }
}
