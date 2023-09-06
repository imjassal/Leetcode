public class Leetcode_2256 {
    public static void main(String[] args) {
        int[] nums={0};
        System.out.println(minimumAverageDifference(nums));
    }
    public static int minimumAverageDifference(int[] nums) {
        if(nums.length==0)
            return 0;
        long[] prefixes = new long[nums.length];
        prefixes[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            prefixes[i] = prefixes[i-1] + nums[i];
        }
        int min = Integer.MAX_VALUE;
        int index = -1;
        for(int i=0;i<nums.length-1;i++){
            int val = (int )Math.abs((prefixes[i]/(i+1))-((prefixes[nums.length-1]-prefixes[i])/(nums.length-1-i)));
            if(val<min){
                min=val;
                index = i;
            }
        }
        if(prefixes[nums.length-1]/nums.length<min)
            index=nums.length-1;
        return index;
    }
}
