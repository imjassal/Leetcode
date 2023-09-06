import java.time.Duration;
import java.time.Instant;

public class Sorts {
    public static void main(String[] args) {
        int[] arr = {13,46,24,52,20,9};
        selectionSort(arr);
        bubbleSort(arr);
        insertionSort(arr);
    }
    static void insertionSort(int[] arr){
        if(arr.length==0||arr.length==1)
            return;
        long before = System.nanoTime();
        for (int i = 0; i <= arr.length - 1; i++) {
            int j = i;
            while (j > 0 && arr[j - 1] > arr[j]) {
                int temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }
        long after = System.nanoTime();
        System.out.println("Time for Insertion Sort:" + (after- before));
        System.out.println("After Insertion sort:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    static void bubbleSort(int[] arr){
        if(arr.length==0||arr.length==1)
            return;
        long before = System.nanoTime();
        for(int i=arr.length-1;i>=0;i--){
            for(int j=0;j<=i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        long after = System.nanoTime();
        System.out.println("Time for Bubble Sort:" + (after-before));
        System.out.println("After Bubble sort:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    static void selectionSort(int[] arr){
        if(arr.length==0||arr.length==1)
            return;
        long before = System.nanoTime();
        for(int i=0;i<arr.length-1;i++){
            int min = i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[min])
                    min = j;
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
        long after = System.nanoTime();
        System.out.println("Time for selection Sort:" + (after-before));
        System.out.println("After selection sort:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
