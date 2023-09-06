import java.util.ArrayList;
import java.util.List;

public class Leetcode_120 {
    public static void main(String[] args) {
//        [[2],[3,4],[6,5,7],[4,1,8,3]]
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        sub.add(2);
        triangle.add(sub);
        sub = new ArrayList<>();
        sub.add(3);
        sub.add(4);
        triangle.add(sub);
        sub = new ArrayList<>();
        sub.add(6);
        sub.add(5);
        sub.add(7);
        triangle.add(sub);
        sub = new ArrayList<>();
        sub.add(4);
        sub.add(1);
        sub.add(8);
        sub.add(3);
        triangle.add(sub);
        sub = new ArrayList<>();
        System.out.println(minimumTotal(triangle));
    }
    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] memo = new int[n][n];
        if (triangle.size() > 1 && triangle.get(0).get(0) == 0 && triangle.get(1).get(0) == 0) {
            return 0;
        }
        return minUtil(triangle, 0, 0, n, memo);
    }

    public static int minUtil(List<List<Integer>> triangle, int i, int pos, int n, int[][] memo) {
        if (pos == n) {
            return 0;
        }
        if (memo[pos][i] != 0) {
            return memo[pos][i];
        }
        List<Integer> arr = triangle.get(pos);
        int min = arr.get(i) + Math.min(minUtil(triangle, i, pos+1, n, memo), minUtil(triangle, i+1, pos+1, n, memo));
        memo[pos][i] = min;
        return min;
    }
}
