public class Leetcode_746 {
    public static void main(String[] args) {
        int[] cost = {1,100,1,1,1,100,1,1,100,1};
        System.out.println(minCostClimbingStairs(cost));
    }
    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int first = cost[0];
        int second = cost[1];
        if (n<=2) return Math.min(first,second);
        for (int i=2; i<n; i++) {
            int temp = cost[i] + Math.min(first,second);
            first = second;
            second = temp;
        }
        return Math.min(first,second);
    }
}
