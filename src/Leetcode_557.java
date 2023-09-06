public class Leetcode_557 {
    public static void main(String[] args) {
        String inp="Let's take LeetCode contest";
        System.out.println(reverseWords(inp));
    }

    public static String reverseWords(String s) {
        String[] words = s.split(" ");
        String newWord="";
        for(String x:words){
            String ans = reverseString(x.toCharArray());
            newWord=newWord.concat(ans+" ");
        }
        return newWord.substring(0,newWord.length()-1);
    }
    public static String reverseString(char[] s) {
        for(int i=0;i<s.length/2;i++){
            char temp = s[i];
            s[i]=s[s.length-1-i];
            s[s.length-1-i] = temp;
        }
        return new String(s);
    }
}
