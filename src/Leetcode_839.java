public class Leetcode_839 {
    public static void main(String[] args) {
        //String[] strs={"nmiwx","mniwx","wminx","mnixw","xnmwi"};
        String[] strs={"koqnn","knnqo","noqnk","nqkon"};
        System.out.println(numSimilarGroups(strs));
    }
    public static int numSimilarGroups(String[] strs) {
        int count = 0;
        if(strs.length==1)
            return count;
            for (int i =  0; i < strs.length-1; i++) {
                if (helper(strs[i], i+1,strs))
                    count++;
            }
        return count;
    }

    public static boolean helper(String str, int index, String[] strss){
        boolean result = false;
        while(index<strss.length&&!result){
            result = similar(str,strss[index++]);
        }
        return result;
    }
    public static boolean similar(String x,String y){
        if(x==y)
            return true;
        if(x.length()!=y.length())
            return false;
        int once = 0;
        for(int i=0;i<x.length();i++){
            if((x.charAt(i)!=y.charAt(i)))
                once++;
            if(once>2)
                return false;
        }
        return true;
    }
}
