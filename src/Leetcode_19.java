public class Leetcode_19 {
    public static void main(String[] args) {
        ListNode fifth = new ListNode(5);
        ListNode fourth = new ListNode(4,fifth);
        ListNode third = new ListNode(3,fourth);
        ListNode second = new ListNode(2,third);
        ListNode head = new ListNode(1,second);
        traverseList(head);
        ListNode output = removeNthFromEnd(head,2);
        System.out.println();
        traverseList(output);
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fPoint=head;
        ListNode sPoint=head;
        while(n!=0) {
            fPoint = fPoint.next;
            n--;
        }
        if (fPoint == null) return head.next;
        while(fPoint.next!=null){
            fPoint=fPoint.next;
            sPoint=sPoint.next;
        }
        sPoint.next = sPoint.next.next;
        return head;
//        ListNode fast = head;
//        ListNode slow = head;
//        for (int i = 0; i < n; i++) fast = fast.next;
//        if (fast == null) return head.next;
//        while (fast.next != null) {
//            fast = fast.next;
//            slow = slow.next;
//        }
//        slow.next = slow.next.next;
//        return head;

    }
    public static void traverseList(ListNode list){
        while(list!=null){
            System.out.print(list.val + "->");
            list=list.next;
        }
    }
}
