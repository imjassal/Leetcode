public class Leetcode_278 {
    public static void main(String[] args) {
        int n=2;
        System.out.println(firstBadVersion(n));
    }

    public static boolean isBadVersion(int m){
        if(m>=2)
            return false;
        return true;
    }
    public static int firstBadVersion(int n) {
//        if(n==1)
//            return 1;
//        int high = n;
//        int low= 1;
//        int mid=0;
//        while(high>low){
//            mid=low + ( high - low ) / 2 ;
//            if(isBadVersion(mid))
//                high=mid;
//            else
//                low=mid+1;
//        }
//        return low;
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
