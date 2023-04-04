public class Leetcode_769 {
    public static void main(String[] args) {
        int[] arr={1,2,0,3};
        System.out.println(maxChunksToSorted(arr));
    }
    public static int maxChunksToSorted(int[] arr) {
        int max=0;
        int count=0;
        for(int i=0;i<arr.length;i++){
            max=Math.max(max,arr[i]);
            if(max==i){
                count++;
            }
        }
        return count;
    }
}
