import java.util.*;
public class Leetcode_2218_DP {
    public static void main(String[] args) {
        List<List<Integer>> piles = new ArrayList<>();
        List<Integer> pile = new ArrayList<>();
        pile.add(1);
        pile.add(100);
        pile.add(3);
        piles.add(pile);
        pile=new ArrayList<>();
        pile.add(7);
        pile.add(8);
        pile.add(9);
        piles.add(pile);
        int k=2;
       System.out.println(maxValueOfCoins(piles,k));
    }
    public static int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int n = piles.size();
        int dp[][] = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            for (int coins = 0; coins <= k; coins++) {
                int currentSum = 0;
                for (int currentCoins = 0; currentCoins <= Math.min((int)piles.get(i - 1).size(), coins); currentCoins++) {
                    if (currentCoins > 0) {
                        currentSum += piles.get(i - 1).get(currentCoins - 1);
                    }
                    dp[i][coins] = Math.max(dp[i][coins], dp[i - 1][coins - currentCoins] + currentSum);
                }
            }
        }
        return dp[n][k];
    }
}
