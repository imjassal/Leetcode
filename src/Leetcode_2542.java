import java.util.*;
public class Leetcode_2542 {
    public static void main(String[] args) {
        int[] nums1={4,2,3,1,1};
        int[] nums2={7,5,10,9,6};
        int k=1;
        System.out.print(maxScore(nums1,nums2,k));
    }
    public static long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] pairs = new int[n][2];
        for(int i=0;i<n;i++){
            pairs[i] = new int[]{nums1[i],nums2[i]};
        }
        Arrays.sort(pairs,(a,b)->b[1]-a[1]);

        PriorityQueue<Integer> pq = new PriorityQueue<>(k,(a,b)->a-b);
        long sum = 0;
        for(int i=0;i<k;i++){
            sum+=pairs[i][0];
            pq.add(pairs[i][0]);
        }
        long answer = sum * pairs[k - 1][1];
        for(int i=k;i<n;i++){
            sum+=pairs[i][0]-pq.poll();
            pq.add(pairs[i][0]);
            answer = Math.max(answer,sum*pairs[i][1]);
        }
        return answer;
    }
}
