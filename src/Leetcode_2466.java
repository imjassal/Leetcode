public class Leetcode_2466 {
    public static void main(String[] args) {
        System.out.print(countGoodStrings(3,3,0,1));
    }
    public static int countGoodStrings(int low, int high, int zero, int one) {
        int mod = 1_000_000_007;
        int[] dp =new int[high+1];
        dp[0] = 1;
        for(int i = 1;i<=high;i++){
            if(i>=zero){
                dp[i] +=dp[i-zero];
            }
            if(i>=one)
                dp[i]+=dp[i-one];
            dp[i]%=mod;
        }
        int count = 0;
        for(int i=low;i<=high;i++){
            count+=dp[i];
            count%=mod;
        }
        return count;
    }
}
