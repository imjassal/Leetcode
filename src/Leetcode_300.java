public class Leetcode_300 {
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.print(lengthOfLIS(nums));
    }
    public static int lengthOfLIS(int[] nums) {
        ///   DP /////
        if(nums.length==0){
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int ans=1;
        for(int i=0; i<dp.length; i++){
            int max = 0;
            for(int j=0; j<i; j++){
                if(nums[i]>nums[j]){
                    max = Math.max(max,dp[j]);
                }
                dp[i] = max+1;
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
        ///   PATIENCE SORTING ////////
        //     int[] tails = new int[nums.length];
        //     int size = 0;
        // for (int x : nums) {
        //     int i = 0, j = size;
        //     while (i != j) {
        //         int m = (i + j) / 2;
        //         if (tails[m] < x)
        //             i = m + 1;
        //         else
        //             j = m;
        //     }
        //     tails[i] = x;
        //     if (i == size) ++size;
        // }
        // return size;
    }
}
