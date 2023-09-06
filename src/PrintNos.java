public class PrintNos {
    public static void main(String[] args) {
        int N=10;
        printNos(N);
    }
    public static void printNos(int N){
        if(N==1)
            System.out.println(N);
        else {
            printNos(N - 1);
            System.out.println(N);
        }
    }
}
