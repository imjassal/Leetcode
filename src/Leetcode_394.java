import java.util.*;
public class Leetcode_394 {
    public static void main(String[] args) {
        //String s="3[a]2[bc]";
       //String s="2[abc]3[cd]ef";
        String s="3[a2[c]]";
        System.out.println(decodeString(s));
    }
    static int pos=0;
    public static String decodeString(String s) {
        StringBuilder str = new StringBuilder();
        int num=0;
        while(pos<s.length()){
            char c = s.charAt(pos);
            if(c>='0'  && c<='9'){
                num=num*10+(c-'0');
            }else if(c>='a' && c<='z'){
                str.append(c);
            }else if(c=='['){
                pos++;
                String temp = decodeString(s);
                for(int i=0; i<num; i++)str.append(temp);
                num=0;
            }else if(c==']'){
                break;
            }
            pos++;
        }
        return str.toString();
    }
}
