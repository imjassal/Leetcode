import java.util.*;
public class Leetcode_1046 {
    public static void main(String[] args) {
        int[] stones= {1};
        System.out.println(lastStoneWeight(stones));
    }
    public static int lastStoneWeight(int[] stones) {
        if(stones.length==1)
            return stones[0];
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0;i<stones.length;i++){
            pQueue.add(stones[i]);
        }
        while(pQueue.size()>=2){
            int num1 = pQueue.peek();
            pQueue.poll();
            int num2 = pQueue.peek();
            pQueue.poll();
            int diff = Math.abs(num1-num2);
            pQueue.add(diff);
        }
        return pQueue.peek();
    }
}
