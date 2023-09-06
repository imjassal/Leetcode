import java.util.*;

public class Leetcode_2130 {
    public static void main(String[] args) {
        ListNode four = new ListNode(4);
        ListNode third = new ListNode(3,four);
        ListNode sec = new ListNode(2,third);
        ListNode head = new ListNode(1,sec);
        System.out.print(pairSum(head));
    }
    public static int pairSum(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode temp = head;
        while(temp!=null){
            list.add(temp.val);
            temp=temp.next;
        }
        int maxSum = Integer.MIN_VALUE;
        for(int i=0;i<list.size()/2;i++){
            int sum = list.get(i)+list.get(list.size()-1-i);
            maxSum = Math.max(sum,maxSum);
        }
        return maxSum;
    }

}
