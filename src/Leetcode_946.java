import java.util.*;
public class Leetcode_946 {
    public static void main(String[] args) {
        int[] pushed ={1,2,3,4,5}, popped = {4,5,3,2,1};
        System.out.println(validateStackSequences(pushed,popped));
    }
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
//        Stack<Integer> st = new Stack<>();
//        int lastIndex = 0;
//        for(int i=0;i<pushed.length;i++){
//            if(st.isEmpty())
//                st.push(pushed[i]);
//            else{
//                if(st.peek()==popped[lastIndex]){
//                    st.pop();
//                    lastIndex++;
//                    i--;
//                }
//                else
//                    st.push(pushed[i]);
//            }
//        }
//        for(int i=lastIndex;i<popped.length;i++){
//            if(st.peek()==popped[i])
//                st.pop();
//            else
//                break;
//        }
//        return st.isEmpty();
//        if (pushed.length != popped.length) {
//            return false;
//        }
//        int n = pushed.length;
//        boolean areEqual = false;
//        for (int i = 0; i < n; i++) {
//            int j = i;
//            int k = 0;
//            while (k < n && pushed[j] == popped[k]) {
//                j = (j + 1) % n;
//                k++;
//            }
//            if (k == n) {
//                areEqual = true;
//                break;
//            }
//        }

        return areCyclicPermutations(pushed,popped);
   }
    public static boolean areCyclicPermutations(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        int n = arr1.length;
        int index = -1;
        for (int i = 0; i < n; i++) {
            if (arr1[0] == arr2[i]) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            int j = (index + i) % n;
            if (arr1[i] != arr2[j]) {
                return false;
            }
        }
        return true;
    }

}
