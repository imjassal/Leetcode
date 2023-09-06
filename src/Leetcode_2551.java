import java.util.*;
public class Leetcode_2551 {
    public static void main(String[] args) {
        int[] weights = {1,3,5,1};
        int k=2;
        System.out.print(putMarbles(weights,k));
    }
    public static long putMarbles(int[] weights, int k) {
        int n = weights.length;
        int[] arr = new int[n-1];
        for(int i=0;i<n-1;++i){
            arr[i] = weights[i]+weights[i+1];
        }
        Arrays.sort(arr,0,n-1);
        long res = 0l;
        for(int i=0;i<k-1;i++){
            res+=arr[n-2-i]-arr[i];
        }
        return res;
    }
}
