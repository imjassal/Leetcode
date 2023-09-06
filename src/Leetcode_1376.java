public class Leetcode_1376 {
    public static void main(String[] args) {
        int n = 22;
        int headId = 7;
        int[] manager = {12,7,18,11,13,21,12,-1,6,5,14,13,14,9,20,13,11,1,1,2,3,19};
        int[] informTime = {0,540,347,586,0,748,824,486,0,777,0,202,653,713,454,0,0,0,574,735,721,772};
        System.out.print(numOfMinutes(n,headId,manager,informTime));
    }
    public static int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (informTime[i] == 0) continue;
            max = Math.max(max, dfs(i, manager, informTime));
        }
        return max;
    }

    private static int dfs(int emp, int[] manager, int[] informTime) {
        if (manager[emp] != -1) {
            informTime[emp] += dfs(manager[emp], manager, informTime);
            manager[emp] = -1;
        }
        return informTime[emp];
    }
}
