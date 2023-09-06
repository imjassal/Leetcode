public class Leetcode_2140 {
    public static void main(String[] args) {
        int[][] questions = {{3,2},{4,3},{4,4},{2,5}};
        System.out.print(mostPoints(questions));
    }
    public static long mostPoints(int[][] questions) {
        float nn= (float) 3/2;
        int n = questions.length;
        long[] dp = new long[n];
        dp[n-1] = questions[n-1][0];
        for(int i=n-2;i>=0;i--){
            dp[i] = questions[i][0];
            int skip = questions[i][1];
            if(1+skip+i<n)
                dp[i]+=dp[1+skip+i];
            dp[i] = Math.max(dp[i],dp[i+1]);
        }
        return dp[0];
    }
}
