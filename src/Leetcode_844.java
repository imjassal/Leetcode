import java.util.*;
public class Leetcode_844 {
    public static void main(String[] args) {
        String s = "abcd",t="bbcd";
        System.out.println(backspaceCompare(s,t));
    }
    public static boolean backspaceCompare(String s, String t) {
        Stack<Character> sStack = new Stack<>();
        Stack<Character> tStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (sStack.isEmpty() && s.charAt(i) != '#')
                sStack.push(s.charAt(i));
            else {
                if (s.charAt(i) == '#') {
                    if (!sStack.isEmpty()) sStack.pop();
                } else
                    sStack.push(s.charAt(i));
            }
        }
        for (int i = 0; i < t.length(); i++) {
            if (tStack.isEmpty() && t.charAt(i) != '#')
                tStack.push(t.charAt(i));
            else {
                if (t.charAt(i) == '#') {
                    if (!tStack.isEmpty()) tStack.pop();
                } else
                    tStack.push(t.charAt(i));
            }
        }
        if (sStack.size() != tStack.size())
            return false;
        else{
            int size = sStack.size();
            for (int i = 0; i < size; i++) {
                if (sStack.peek() != tStack.peek()) {
                    return false;
                } else {
                    sStack.pop();
                    tStack.pop();
                }
            }
    }
        return true;
    }
}
