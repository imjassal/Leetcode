public class Leetcode_383 {
    public static void main(String[] args) {
        String ransomNote="aa",magazine="aba";
        System.out.print(canConstruct(ransomNote,magazine));
    }
    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] arr=new int[26];
        for(char ch:magazine.toCharArray())
            arr[ch-'a']++;
        for(char ch:ransomNote.toCharArray()){
            arr[ch-'a']--;
            if(arr[ch-'a']<0)
                return false;
        }
        return true;
    }

}
