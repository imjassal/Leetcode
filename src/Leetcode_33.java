public class Leetcode_33 {
    public static void main(String[] args) {
        int[] nums = {5,1,3};
        System.out.print(search(nums,5));
    }
    public static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        while(high>=low){
            int mid = low+(high-low)/2;
            if(nums[mid]==target)
                return mid;
            else if(nums[low]<=target && target<=nums[mid])
                high=mid-1;
            else
                low=mid+1;
        }
        return -1;
    }
}
