public class Leetcode_977 {
    public static void main(String[] args) {
        int[] nums= {-4,-1,0,3,10};
        sortedSquares(nums);
    }
    public static int[] sortedSquares(int[] nums) {
        int fp = 0;
        int sp = nums.length-1;
        int n = nums.length-1;
        int[] out= new int[nums.length];
        while(sp>=fp){
            if(Math.abs(nums[sp])>Math.abs(nums[fp]))
            {
                out[n] = nums[sp]*nums[sp];
                sp--;
            }
            else
            {
                out[n] = nums[fp]*nums[fp];
                fp++;
            }
            n--;
        }
        return out;
    }
}
