public class Leetcode_258 {
    public static void main(String[] args) {
        int num = 511;
        System.out.println(addDigits(num));
    }
    public static int addDigits(int num) {
        if(num == 0) return 0;
        else if(num % 9 == 0) return 9;
        else return num % 9;
    }
}
