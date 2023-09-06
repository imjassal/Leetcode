import java.util.*;
public class Enocde_Decode {
    public static void main(String[] args) {
        List<String> strs = new ArrayList<>();
        strs.add("lint");
        strs.add("code");
        strs.add("love");
        strs.add("you");
        String str = encode(strs);
        List<String> ans = decode(str);
    }

    public static String encode(List<String> strs) {
        StringBuffer s = new StringBuffer();
        for(String st:strs){
            s.append(st);
            s.append(";");
        }
        return s.toString();
    }

    public static List<String> decode(String str) {
        String[] s = str.split(";");
        List<String> strs = new ArrayList<>();
        for(int i=0;i<s.length;i++){
            strs.add(s[i]);
        }
        return strs;
    }
}
