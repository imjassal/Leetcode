import java.util.*;
public class Leetcode_2215 {
    public static void main(String[] args) {
    int[] nums1 = {1,2,3,3}, nums2 = {1,1,2,2};
        findDifference(nums1,nums2);
    }
    public static List<Integer> getElementsOnlyInFirstList(int[] nums1, int[] nums2) {
        Set<Integer> onlyInNums1 = new HashSet<> ();
        Set<Integer> existsInNums2 = new HashSet<> ();
        for (int num : nums2) {
            existsInNums2.add(num);
        }
        for (int num : nums1) {
            if (!existsInNums2.contains(num)) {
                onlyInNums1.add(num);
            }
        }
        return new ArrayList<>(onlyInNums1);
    }


    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        //return Arrays.asList(getElementsOnlyInFirstList(nums1, nums2), getElementsOnlyInFirstList(nums2, nums1));
        List<Integer> diff1 = getDifference(nums1, nums2);
        List<Integer> diff2 = getDifference(nums2, nums1);
        return Arrays.asList(diff1, diff2);
    }

    private static List<Integer> getDifference(int[] nums1, int[] nums2) {
        List<Integer> difference = new ArrayList<>();
        boolean[] seen = new boolean[2001];

        for (int i : nums2) {
            seen[i] = true;
        }

        for (int i : nums1) {
            if (!seen[i]) {
                seen[i] = true;
                difference.add(i);
            }
        }
        return difference;
    }
}
