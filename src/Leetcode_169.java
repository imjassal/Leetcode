public class Leetcode_169 {
    public static void main(String[] args) {
        int[] nums={6,5,5};
        System.out.print(majorityElement(nums));
    }
    public static int majorityElement(int[] nums) {
        int count = 0;
        int element = nums[0];
        int currElement = nums[0];
        for(int i=0;i<nums.length;i++){
            currElement=nums[i];
            if(count==0)
            {
                element = nums[i];
                count++;
            }
            else if(currElement==element)
                count++;
            else if(currElement!=element)
                count--;
        }
        return element;
    }
}
