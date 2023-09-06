public class Leetcode_153 {
    public static void main(String[] args) {
        int[]nums = {1,2,3,4,5,0};
        System.out.print(findMin(nums));
    }
    public static int findMin(int[] nums) {
        int left = 0, right = nums.length-1, minVal = Integer.MAX_VALUE;

        while (left <= right) {
            if (nums[left] < nums[right]) {
                minVal = Math.min(minVal, nums[left]);
                break;
            }
            int mid = left + (right - left) / 2;

            if (nums[left] <= nums[mid]) {
                minVal = Math.min(minVal, nums[left]);
                left = mid + 1;
            } else {
                minVal = Math.min(minVal, nums[mid]);
                right = mid - 1;
            }
        }
        return minVal;
    }
}
