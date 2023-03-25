public class Leetcode_2348 {
    public static void main(String[] args) {
        int[] arr={0,0,0,2,0,0};
        System.out.println(zeroFilledSubarray(arr));
    }
    public static long zeroFilledSubarray(int[] nums) {
        long count=0;
        long consecutive = 0;
        boolean continuous = false;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0&&!continuous){
                continuous=true;
            }
            if(nums[i]==0&&continuous){
                consecutive+=1;
            }
            else if(nums[i]!=0){
                continuous=false;
                count+=consecutive*(consecutive+1)/2;
                consecutive=0;
            }
        }
        count+=consecutive*(consecutive+1)/2;
        return count;
    }
}
