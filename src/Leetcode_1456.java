public class Leetcode_1456 {
    public static void main(String[] args) {
        String s = "weallloveyou";
        System.out.print(maxVowels(s,7));
    }
    public static int maxVowels(String s, int k) {
        String VOWELS = "aeiou";
        int count = 0;
        int answer = 0;
        int[] arr = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            count += VOWELS.indexOf(s.charAt(i))!=-1 ? 1 : 0;
            arr[i] = count;
        }
        for (int i = 0; i <= s.length() - k; i++) {
            int end = i + k - 1;
            if (i == 0) {
                answer = Math.max(answer, arr[end]);
            } else {
                answer = Math.max(answer, arr[end] - arr[i - 1]);
            }
        }
        return answer;
    }
}
