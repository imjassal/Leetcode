import java.util.*;
public class FindAllSubSequences {
   static int count;
    public static void main(String[] args) {
        int[] nums = {2,3,3,4,6,7};
        int val = 12;
      System.out.print(numSubseq(nums,val));

    }
        public static int numSubseq(int[] A, int target) {
            Arrays.sort(A);
            int res = 0, n = A.length, l = 0, r = n - 1, mod = (int)1e9 + 7;
            int[] pows = new int[n];
            pows[0] = 1;
            for (int i = 1 ; i < n ; ++i)
                pows[i] = pows[i - 1] * 2 % mod;
            while (l <= r) {
                if (A[l] + A[r] > target) {
                    r--;
                } else {
                    res = (res + pows[r - l++]) % mod;
                }
            }
            return res;
        }
    }
