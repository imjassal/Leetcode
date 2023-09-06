import java.util.*;
public class Leetcode_4 {
    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {1,1};
        System.out.print(findMedianSortedArrays(nums1,nums2));
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> overAll = new ArrayList<>();
        for(int i = 0;i<nums1.length;i++){
            overAll.add(nums1[i]);
        }
        for(int i=0;i<nums2.length;i++){
            int index = Collections.binarySearch(overAll, nums2[i]);
            if(index<0)
                overAll.add(Math.abs(index+1),nums2[i]);
            else if(index>=0)
                overAll.add(index,nums2[i]);
        }
        int size = overAll.size();
        int median = size/2;
        double ans = 0.0;
        if(size%2==0){
            ans = overAll.get(median) + overAll.get(median - 1);
            ans/=2;
        }
        else
            ans = overAll.get(median);
        return ans;
    }
}
