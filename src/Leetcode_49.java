import java.util.*;
public class Leetcode_49 {
    public static void main(String[] args) {
       String[] strs = {"eat","tea","tan","ate","nat","bat"};
       groupAnagrams(strs);
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        ///// *****HASHMAP + SORTING APPROACH*****///////
//        if (strs.length == 0) return new ArrayList();
//        Map<String, List> ans = new HashMap<String, List>();
//        for (String s : strs) {
//            char[] ca = s.toCharArray();
//            Arrays.sort(ca);
//            String key = String.valueOf(ca);
//            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
//            ans.get(key).add(s);
//        }
//        return new ArrayList(ans.values());
        ///// *****HASHMAP + COUNT APPROACH*****///////
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) count[c - 'a']++;

//            StringBuilder sb = new StringBuilder("");
//            for (int i = 0; i < 26; i++) {
//                sb.append('#');
//                sb.append(count[i]);
//            }
            String key = count.toString();
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }
}
