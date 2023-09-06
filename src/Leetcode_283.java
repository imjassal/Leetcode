public class Leetcode_283 {
    public static void main(String[] args) {
        int[] nums={0,1,0,3,12};
        moveZeroes(nums);
        for(int num:nums)
            System.out.println(num);
    }
    public static void moveZeroes(int[] nums) {
        int n = nums.length;

        if(n == 0 || n == 1) return;

        int left = 0;
        int right = 0;

        while(right < n) {
            if(nums[right] == 0) right++;
            else {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right++;
            }
        }

    }
}
