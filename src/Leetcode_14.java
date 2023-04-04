public class Leetcode_14 {
    public static void main(String[] args) {
        String[] strs={"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }
    public static String longestCommonPrefix(String[] strs) {
        int smallestString = Integer.MAX_VALUE;
        String small="";
        for(String str:strs){
            if(str.length()<smallestString){
                smallestString=str.length();
                small=str;
            }
        }
        if(smallestString==0)
            return "";
        boolean out=false;
        while(!out){
            int count=0;
            for(String s:strs){
                if(s.indexOf(small)==0)
                    count++;
            }
            if(count==strs.length)
                out=true;
            else {
                if(small.length()>0)
                small = small.substring(0, small.length() - 1);
                else
                {
                    small="";
                    out=true;
                }
            }
        }
        return small;
    }
}
