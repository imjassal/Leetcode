import java.util.*;
public class Leetcode_2405 {
    public static void main(String[] args) {
        String s = "ssssss";
        System.out.println(partitionString(s));
    }
    public static int partitionString(String s) {
        int ans = 0;
        Set<Character> ch=new HashSet<>();
        ch.add(s.charAt(0));
        for(int i=1;i<s.length();i++){
            if(ch.contains(s.charAt(i))){
                ans++;
                ch=new HashSet<>();
                ch.add(s.charAt(i));
            }
            ch.add(s.charAt(i));
        }
        return ++ans;
    }
}
