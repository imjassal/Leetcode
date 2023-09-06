import java.util.List;

public class ListNode_160 {
    public static void main(String[] args) {
        ListNode last = new ListNode(3);
        ListNode sLast = new ListNode(2,last);
        ListNode tLast = new ListNode(8,sLast);
        ListNode aSec = new ListNode(1,tLast);
        ListNode headA = new ListNode(4,aSec);
        ListNode bThird = new ListNode(1,tLast);
        ListNode bSec = new ListNode(6,bThird);
        ListNode headB = new ListNode(5,bSec);
        ListNode abs = getIntersectionNode(last,sLast);
        abs.print(abs);
    }
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB == null)
            return null;
        ListNode aTemp = headA,bTemp = headB;
        int sizeA = 0;
        int sizeB = 0;
        while(aTemp!=null&&aTemp.next!=null){
            aTemp = aTemp.next;
            sizeA++;
        }
        while(bTemp!=null&&bTemp.next!=null){
            bTemp = bTemp.next;
            sizeB++;
        }
        if(bTemp!=aTemp)
            return null;

        if(sizeB>sizeA){
            while(sizeB-sizeA>0){
                headB = headB.next;
                sizeB--;
            }
        }
        else
            while(sizeA-sizeB>0){
                headA = headA.next;
                sizeA--;
            }
            boolean matched = false;
            while(headA!=null&&headA.next!=null){
                if(headA==headB)
                    return headA;
                headA=headA.next;
                headB=headB.next;
            }
        return null;
    }
}
