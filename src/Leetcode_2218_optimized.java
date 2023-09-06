import java.util.ArrayList;
import java.util.List;

public class Leetcode_2218_optimized {
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
        int[] mv = new int[k + 1];
        int[] pileSum = new int[k + 1];
        for (List<Integer> pile : piles) {
            int n = Math.min(k, pile.size());
            int sum = 0;
            for (int i = 1; i <= n; i++)
                pileSum[i] = sum += pile.get(i - 1);
            for (int i = k; i > 0; i--) {
                int max = 0;
                for (int j = Math.min(i, n); j >= 0; j--)
                    max = Math.max(max, pileSum[j] + mv[i - j]);
                mv[i] = max;
            }
        }
        return mv[k];
    }
}

