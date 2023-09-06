public class Leetcode_21 {
    public static void main(String[] args) {
        ListNode firstThird = new ListNode(4);
        ListNode firstSecond = new ListNode(2,firstThird);
        ListNode firsthead = new ListNode(1,firstSecond);
        ListNode secondThird = new ListNode(4);
        ListNode secondSecond = new ListNode(3,secondThird);
        ListNode secondhead = new ListNode(1,secondSecond);
        ListNode ans = mergeTwoLists(firsthead,secondhead);
        traverseList(ans);
    }
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null && list2==null)
            return null;
        if(list1==null)
            return list2;
        if(list2==null)
            return list1;
        ListNode out = new ListNode();
        if(list1.val>list2.val){
            out.val = list2.val;
            out.next = mergeTwoLists(list1,list2.next);
        }
        else{
            out.val = list1.val;
            out.next = mergeTwoLists(list1.next,list2);
        }
        return out;
    }
    public static void traverseList(ListNode list){
        while(list!=null){
            System.out.print(list.val + "->");
            list=list.next;
        }
    }
}
