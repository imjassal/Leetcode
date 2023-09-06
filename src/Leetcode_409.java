import java.util.*;
public class Leetcode_409 {
    public static void main(String[] args) {
        String s="ccc";
        System.out.print(longestPalindrome(s));
    }
    public static int longestPalindrome(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        int count = 0;
        boolean add = false;
        for (Map.Entry<Character,Integer> entry : map.entrySet()) {
            if(entry.getValue()%2==0)
                count+=entry.getValue();
            else if(entry.getValue()>2 && entry.getValue()%2!=0 && !add ){
                count+= entry.getValue();
                add=true;
            }
            else if(entry.getValue()>2 && entry.getValue()%2!=0 && add )
                count+= (entry.getValue()/2)*2;
            else if(entry.getValue()<2 && entry.getValue()%2!=0 && !add){
                count+=1;
                add=true;
            }
        }
        return count;
    }
}
