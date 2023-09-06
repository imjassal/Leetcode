public class Palindrome {
    public static void main(String[] args) {
        int n=555;
        System.out.print(is_palindrome(n));
    }
    public static String is_palindrome(int n)
    {
        int sol=n;
        int temp = 0;
        while(n>0)
        {
            temp = (temp*10)+(n%10);
            n=n/10;
        }
        if(temp==sol)
            return "Yes";
        return "No";
    }
}
