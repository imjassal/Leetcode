import java.util.*;
public class Leetcode_83 {
    public static void main(String[] args) {
        ListNode last = new ListNode(3);
        ListNode sLast = new ListNode(3,last);
        ListNode tLast = new ListNode(2,sLast);
        ListNode fLast = new ListNode(1,tLast);
        ListNode head = new ListNode(1,fLast);
        head.print(deleteDuplicates(head));
    }
    public static ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode temp = head;
        while (temp != null && temp.next != null)
        {
            if (temp.next.val==temp.val)
            {
                temp.next=temp.next.next;
                continue;
            }
            temp=temp.next;
        }
        return head;

    }
}
