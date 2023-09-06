public class Leetcode_1493 {
    public static void main(String[] args) {
        int[] nums = {1,1,1};
        System.out.print(longestSubarray(nums));
    }
    public static int longestSubarray(int[] nums) {
        int zeros = 0,start=0,windowSize=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)
                zeros++;
            if(zeros>1){
                if(nums[start]==0)
                    zeros--;
                start++;
            }
            windowSize = Math.max(windowSize,i-start);
        }
        return windowSize;
    }
}
