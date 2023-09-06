import java.util.*;
public class Leetcode_299 {
    public static void main(String[] args) {
        String secret = "11";
        String guess = "10";
        System.out.println(getHint(secret,guess));
    }
    public static String getHint(String secret, String guess) {
        HashMap<Character, Integer> shm = new HashMap<>();
        int bulls = 0, cows = 0;
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)){
                bulls++;
                guess=guess.substring(0,i)+guess.substring(i+1,guess.length());
            }
            else
            shm.put(secret.charAt(i), shm.getOrDefault(secret.charAt(i), 0) + 1);
        }
        for (int i = 0; i < guess.length(); i++) {
                if (shm.containsKey(guess.charAt(i)) && shm.get(guess.charAt(i))>0)
           cows++;
            shm.put(guess.charAt(i), shm.getOrDefault(guess.charAt(i), 0) - 1);
        }
        return String.valueOf(bulls) + "A" + String.valueOf(cows) + "B";
    }
}
