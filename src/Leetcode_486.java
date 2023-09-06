public class Leetcode_486 {
    public static void main(String[] args) {
        int[] nums = {1,5,233,7};
        System.out.print(PredictTheWinner(nums));
    }
    private static int maxDiff(int[] nums, int left, int right, int n) {
        if (left == right) {
            return nums[left];
        }

        int scoreByLeft = nums[left] - maxDiff(nums, left + 1, right, n);
        int scoreByRight = nums[right] - maxDiff(nums, left, right - 1, n);

        return Math.max(scoreByLeft, scoreByRight);
    }

//    public static boolean PredictTheWinner(int[] nums) {
//        int n = nums.length;
//
//        return maxDiff(nums, 0, n - 1, n) >= 0;
//   }
    public static boolean PredictTheWinner(int[] nums) {
    int n = nums.length;
    int[][] dp = new int[n][n];
    for(int i = 0 ; i < n ; i++){
        dp[i][i] = nums[i];
    }

    for(int i = n-2; i >= 0 ; i--){
        for(int j = i+1 ; j < n ; j++ ){
            dp[i][j] = Math.max( nums[i] - dp[i+1][j],  nums[j] - dp[i][j-1]);
        }
    }

    return dp[0][n -1] >= 0;

}
}
