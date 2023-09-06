public class Leetcode_744 {
    public static void main(String[] args) {
        char[] letters = {'c','f','j'};
        System.out.print(nextGreatestLetter(letters,'k'));
    }
    public static char nextGreatestLetter(char[] letters, char target) {
        for(char ch:letters){
            if(ch>target)
                return ch;
        }
        return letters[0];
    }
}
