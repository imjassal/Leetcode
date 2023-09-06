import sun.lwawt.macosx.CSystemTray;

public class Leetcode_392 {
    public static void main(String[] args) {
        String s = "abc", t = "ahbgdc";
        System.out.println(isSubsequence(s,t));
    }
    public static boolean isSubsequence(String s, String t) {
        if(s.length()>t.length())
            return false;
        if(t==s)
            return true;
        int i = 0;
        int j=0;
        while(j<t.length()){
            if(i<s.length()&&s.charAt(i)==t.charAt(j)){
                i++;
            }
            j++;
        }
        return i==s.length();
    }
}
