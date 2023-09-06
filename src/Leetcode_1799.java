import java.util.*;

public class Leetcode_1799 {
    public static void main(String[] args) {
        int[] nums={925612,737192,813525,707250};
        System.out.print(maxScore(nums));
    }
//    public static int maxScore(int[] nums) {
//        int maxScore = 0;
//        int subScore = 0;
//        int temp = 0;
//        int opearations = 1;
//        Set<Integer> set = new HashSet<>();
//        for(int i=0;i<nums.length;i++){
//            if(set.size()==nums.length)
//                break;
//            subScore = 0;
//            if(set.contains(i))
//                continue;
//            else
//                set.add(i);
//            for(int j=i+1;j<nums.length;j++){
//                if(i==j)
//                    continue;
//                if(set.contains(j))
//                    continue;;
//                int gcd = calc(nums[i],nums[j]);
//                gcd*=opearations;
//                if(gcd>subScore) {
//                    subScore = gcd;
//                    temp = j;
//                }
//            }
//            set.add(temp);
//            maxScore+=subScore;
//            opearations++;
//        }
//        return maxScore;
//    }
//    public static int calc(int a,int b){
//        if(a==0)
//            return b;
//        else if(b==0)
//            return a;
//        int min = Math.min(a,b);
//        int max = Math.max(a,b);
//        return calc(max%min,min);
//    }
    public static int backtrack(int[] nums, int mask, int pairsPicked, int[] memo) {
        // If we have picked all the numbers from 'nums' array, we can't get more score.
        if (2 * pairsPicked == nums.length) {
            return 0;
        }

        // If we already solved this sub-problem then return the stored result.
        if (memo[mask] != -1) {
            return memo[mask];
        }

        int maxScore = 0;

        // Iterate on 'nums' array to pick the first and second number of the pair.
        for (int firstIndex = 0; firstIndex < nums.length; ++firstIndex) {
            for (int secondIndex = firstIndex + 1; secondIndex < nums.length; ++secondIndex) {

                // If the numbers are same, or already picked, then we move to next number.
                if (((mask >> firstIndex) & 1) == 1 || ((mask >> secondIndex) & 1) == 1) {
                    continue;
                }

                // Both numbers are marked as picked in this new mask.
                int newMask = mask | (1 << firstIndex) | (1 << secondIndex);

                // Calculate score of current pair of numbers, and the remaining array.
                int currScore = (pairsPicked + 1) * gcd(nums[firstIndex], nums[secondIndex]);
                int remainingScore = backtrack(nums, newMask, pairsPicked + 1, memo);

                // Store the maximum score.
                maxScore = Math.max(maxScore, currScore + remainingScore);
                // We will use old mask in loop's next interation,
                // means we discarded the picked number and backtracked.
            }
        }

        // Store the result of the current sub-problem.
        memo[mask] = maxScore;
        return maxScore;
    }

    public static int maxScore(int[] nums) {
        int memoSize = 1 << nums.length; // 2^(nums array size)
        int[] memo = new int[memoSize];
        Arrays.fill(memo, -1);
        return backtrack(nums, 0, 0, memo);
    }

    // Utility function to calculate the gcd of two numbers.
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
