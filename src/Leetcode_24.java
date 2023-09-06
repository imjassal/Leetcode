public class Leetcode_24 {
    public static void main(String[] args) {
        ListNode fourth = new ListNode(4);
        ListNode third = new ListNode(3,fourth);
        ListNode second = new ListNode(2,third);
        ListNode head = new ListNode(1,second);
        ListNode ans = swapPairs(head);
        ans.print(ans);
    }
    public static ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode temp = head;
        ListNode d = new ListNode(0), a;
        d.next = head;
        a=d;
        while(head!=null&&head.next!=null) {
            a.next = head.next;
            head.next = head.next.next;
            a.next.next = head;
            a = a.next.next;
            head =  head.next;
        }
        return d.next;
    }}
