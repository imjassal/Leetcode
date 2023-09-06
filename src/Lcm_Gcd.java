import java.util.LinkedList;
import java.util.Stack;

public class Lcm_Gcd {
    public static void main(String[] args) {
        long n1 = 697035;
        long n2 = 384958;
        Long[] ans = lcmAndGcd(n1,n2);
        for(Long a:ans)
            System.out.print(a+",");
    }
    static Long[] lcmAndGcd(Long A , Long B) {
        long gcd = 0;
        long lcm = 0;
        long min = Math.min(A,B);
        long max = Math.max(A,B);
       gcd = gcd(max%min,min);
        lcm = (max*min)/gcd;
        return new Long[]{lcm,gcd};
    }
    static long gcd(long a,long b){
        if(a==0)
            return b;
        else if(b==0)
            return a;
        long min = Math.min(a,b);
        long max = Math.max(a,b);
        return gcd(max%min,min);
    }
}
