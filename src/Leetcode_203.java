public class Leetcode_203 {
    public static void main(String[] args) {
        ListNode last = new ListNode(7);
        ListNode sLast = new ListNode(7,last);
        ListNode tLast = new ListNode(7,sLast);
        ListNode aSec = new ListNode(7,tLast);
        ListNode bThird = new ListNode(7,aSec);
        ListNode headA = new ListNode(7,bThird);
        headA.print(removeElements(headA,7));
    }
    public static ListNode removeElements(ListNode head, int val) {
        ListNode temp = new ListNode();
        temp.next=head;
        while(temp!=null&&temp.next!=null){
            if(temp.next.val == val) {
                temp.next = temp.next.next;
                continue;
            }
            temp=temp.next;
        }
        return head;
    }
}
