import java.util.Arrays;
import java.util.Comparator;

public class Leetcode_435 {
    public static void main(String[] args) {
        int[][] data = {{1,2},{2,3},{3,4},{1,3}};
        System.out.print(eraseOverlapIntervals(data));
    }
    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int ans = 0;
        int k = Integer.MIN_VALUE;

        for (int i = 0; i < intervals.length; i++) {
            int x = intervals[i][0];
            int y = intervals[i][1];

            if (x >= k) {
                // Case 1
                k = y;
            } else {
                // Case 2
                ans++;
            }
        }

        return ans;
    }
}
