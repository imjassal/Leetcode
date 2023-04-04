import java.util.*;
public class Leetcode_20 {
    public static void main(String[] args) {
        String parenthesis = "{[]}";
        isValid(parenthesis);
    }
    public static  void isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(st.size()==0){
                st.push(s.charAt(i));
            }
            else{
                if(s.charAt(i)==')')
                {
                    char ch=st.peek();
                    if(ch=='(')
                        st.pop();
                    else
                        st.push(s.charAt(i));
                }
                else if(s.charAt(i)=='}')
                {
                    char ch=st.peek();
                    if(ch=='{')
                        st.pop();
                    else
                        st.push(s.charAt(i));
                }
                else if(s.charAt(i)==']')
                {
                    char ch=st.peek();
                    if(ch=='[')
                        st.pop();
                    else
                        st.push(s.charAt(i));
                }
                else
                    st.push(s.charAt(i));

            }
        }
         System.out.println(st.isEmpty());
    }
}
