public class Leetcode_238 {
    public static void main(String[] args) {
        int[] nums = {0,4,0};
        productExceptSelf(nums);
    }
    public static int[] productExceptSelf(int[] nums) {
        double product  = 1;
        int containsZero = 0;
        for(int i=0;i<nums.length;i++)
            if(nums[i]!=0)
                product*=nums[i];
            else
                containsZero++;
        for(int i=0;i<nums.length;i++)
            if(nums[i]==0&&containsZero==1)
                nums[i] = (int) product;
            else if(containsZero==0)
                nums[i] = (int) (product/nums[i]);
            else
                nums[i] = 0;
        return nums;
    }

}
