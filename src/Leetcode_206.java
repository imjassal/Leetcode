public class Leetcode_206 {
    public static void main(String[] args) {
        ListNode firstThird = new ListNode(4);
        ListNode firstSecond = new ListNode(2,firstThird);
        ListNode firsthead = new ListNode(1,firstSecond);
        reverseList(firsthead);
    }
    public static ListNode reverseList(ListNode head) {
//        ListNode prev = null;
//        ListNode current = head;
//        ListNode next = null;
//        while(current!=null){
//            next = current.next;
//            current.next = prev;
//            prev = current;
//            current = next;
//        }
//
//        return prev;
        if(head == null || head.next == null) return head;
         ListNode newHead = reverseList(head.next);
         head.next.next = head;
         head.next = null;
         return newHead;
    }
}
