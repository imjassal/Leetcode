public class EvenlyDivides {
    public static void main(String[] args) {
        int N=10059;
        System.out.print(evenlyDivides(N));
    }
    static int evenlyDivides(int N){
        int temp = N;
        int count=0;
        while(temp>=10){
            int val = temp%10;
            temp=temp/10;
            if(val==0)
                continue;
            if(N%val==0)
                count++;

        }
        if(N%temp==0&&temp!=0)
            count++;
        return count;
    }
}
