public class Leetocde_1822 {
    public static void main(String[] args) {
        int[] nums={-1,-2,-3,-4,3,2,1};
        System.out.println(arraySign(nums));
    }
    public static int arraySign(int[] nums) {
        int ans=1;
        for(int num:nums)
            ans = ans*num;
        if(ans>0)
            return 1;
        if(ans<0)
            return -1;
        return 0;
    }
}

