import java.util.Arrays;

public class Leetcode_1402 {
    public static void main(String[] args) {
        int[] satisfaction={-1,-8,0,5,-9};
        System.out.println(maxSatisfaction(satisfaction));
    }
    public static int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int maxSatisfaction = 0;
        int suffixSum = 0;
        for (int i = satisfaction.length - 1; i >= 0 && suffixSum + satisfaction[i] > 0; i--) {
            suffixSum += satisfaction[i];
            maxSatisfaction +=  suffixSum;
        }
        return maxSatisfaction;
    }
}
