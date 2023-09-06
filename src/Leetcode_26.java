public class Leetcode_26 {
    public static void main(String[] args) {
        int[] arr = {0,0,1,1,1,2,2,3,3,4};
        int loop = removeDuplicates(arr);
        for(int i=0;i<loop;i++)
            System.out.print(arr[i]);
    }
    public static int removeDuplicates(int[] nums) {
        int index=1;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]!=nums[i+1]){
                nums[index]=nums[i+1];
                index++;
            }
        }
        return index;
    }
}
