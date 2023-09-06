import java.util.*;
public class Leetcode_2024 {
    public static void main(String[] args) {
        System.out.print(maxConsecutiveAnswers("TFFT",1));
    }
    public static int maxConsecutiveAnswers(String answerKey, int k) {
        char[] chars = answerKey.toCharArray();
        int result = 0, max = 0, count[] = new int[128];
        for (int i = 0; i < chars.length; i++)
            if (result - (max = Math.max(max, ++count[chars[i]])) < k) result++;
            else count[chars[i - result]]--;
        return result;
    }
}
