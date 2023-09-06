public class Leetcode_1768 {
    public static void main(String[] args) {
        String word1 = "ab",word2 = "pqrs";
        System.out.println(mergeAlternately(word1,word2));
    }
    public static String mergeAlternately(String word1, String word2) {
        boolean word1Longer = false;
        boolean word2Longer = false;
        int word1Length = word1.length();
        int word2Length = word2.length();
        int loop = 0;
        if(word1Length>word2Length){
            loop=word2Length;
            word1Longer = true;
        }
        else{
            loop = word1Length;
            word2Longer = true;
        }
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<loop;i++){
            ans.append(word1.charAt(i));
            ans.append(word2.charAt(i));
        }
        if(word1Longer)
            ans.append(word1.substring(loop));
        else if(word2Longer)
            ans.append(word2.substring(loop));
        return ans.toString();
    }
}
