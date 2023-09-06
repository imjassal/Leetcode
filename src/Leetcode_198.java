public class Leetcode_198 {
    public static void main(String[] args) {
        int[] nums= {2,1,1,2};
       // int[] nums={};
        System.out.println(rob(nums));
    }
    public static int rob(int[] nums) {
        int[] robbed = new int[nums.length+1];
        robbed[0] = 0;
        robbed[1] = nums[0];
        for(int i=1;i<nums.length;i++){
            int val = nums[i];
            robbed[i+1] = Math.max(robbed[i],robbed[i-1]+val);
        }
        return robbed[nums.length];
    }
}
