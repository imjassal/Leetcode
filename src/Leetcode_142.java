public class Leetcode_142 {
    public static void main(String[] args) {
        ListNode firstFourth= new ListNode(4);
        ListNode firstThird = new ListNode(0,firstFourth);
        ListNode firstSecond = new ListNode(2,firstThird);
        firstFourth.next = firstSecond;
        ListNode firsthead = new ListNode(3,firstSecond);
        ListNode out = detectCycle(firsthead);
    }
    public static ListNode detectCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow)
                break;
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        fast=head;
        while(fast!=slow)
        {
            fast=fast.next;
            slow=slow.next;
        }
        return fast;
    }
}
