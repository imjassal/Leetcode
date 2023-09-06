import java.util.Arrays;

public class Leetcode_673 {
    public static void main(String[] args) {
        int[] nums = {1,3,5,4,7};
        System.out.print(findNumberOfLIS(nums));
    }
    public static int findNumberOfLIS(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int[] length = new int[nums.length];
        int[] count = new int[nums.length];
        Arrays.fill(length, 1);
        Arrays.fill(count, 1);
        for(int i=0; i<nums.length; i++){
            int max = 0;
            for(int j=0; j<i; j++){
                if(nums[j]<nums[i]){
                    if(length[j]+1>length[i]){
                        length[i] = length[j]+1;
                        count[i] = 0;
                    }
                     if(length[i]==length[j]+1)
                        count[i]+=count[j];
                }
            }
        }
        int maxLength=0;
        int ans = 0;
        for(int len:length)
            maxLength = Math.max(len,maxLength);
        for(int i = 0;i<length.length;i++){
            if(length[i]==maxLength)
                ans+=count[i];
        }
        return ans;
    }
}
