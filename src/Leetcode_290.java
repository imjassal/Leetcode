import java.util.*;
public class Leetcode_290 {
    public static void main(String[] args) {
        String pattern = "abba", s = "dog cat cat dog";
        System.out.print(wordPattern(pattern,s));
    }
    public static boolean wordPattern(String pattern, String s) {
        String[] sArr = s.split(" ");
        HashMap<Character,String> hm = new HashMap<>();
        HashMap<String,Character> map = new HashMap<>();
        for(int i =0;i<sArr.length;i++){
            if(hm.containsKey(pattern.charAt(i))){
               if(!hm.get(pattern.charAt(i)).equals(sArr[i]))
                   return false;
            }
            else
                hm.put(pattern.charAt(i),sArr[i]);
        }
        for(int i =0;i<sArr.length;i++){
            if(map.containsKey(sArr[i])){
                if(!map.get(sArr[i]).equals(pattern.charAt(i)))
                    return false;
            }
            else
                map.put(sArr[i],pattern.charAt(i));
        }
        return true;
    }
}
