public class Leetcode_859 {
    public static void main(String[] args) {
        String s = "ab";
        String goal = "ab";
        System.out.print(buddyStrings(s,goal));
    }
    public static boolean buddyStrings(String s, String goal) {
        if(s.length()!=goal.length())
            return false;
        int sIndex=-1;
        int goalIndex = -1;
        if(s.equals(goal)){
            int[] arr = new int[26];
            for(char c:s.toCharArray()){
                arr[c-'a']+=1;
                if(arr[c-'a']==2)
                    return true;
            }
            return false;
        }
        else {
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)!=goal.charAt(i)){
                    if(sIndex==-1)
                        sIndex = i;
                    else if(goalIndex==-1)
                        goalIndex = i;
                    else
                        return false;
                }
            }
            if(goalIndex==-1||sIndex==-1)
                return false;
        }
        return s.charAt(sIndex) == goal.charAt(goalIndex) && s.charAt(goalIndex) == goal.charAt(sIndex);
    }
}
