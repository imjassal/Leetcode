import java.util.*;
public class Leetcode_116 {
    public static void main(String[] args) {
        TreeLinkNode left_left_child = new TreeLinkNode(4);
        TreeLinkNode left_right_child = new TreeLinkNode(5);
        TreeLinkNode right_left_child = new TreeLinkNode(6);
        TreeLinkNode right_right_child = new TreeLinkNode(7);
        TreeLinkNode left_child = new TreeLinkNode(2,left_left_child,left_right_child,null);
        TreeLinkNode right_child = new TreeLinkNode(3,right_left_child,right_right_child,null);
        TreeLinkNode root = new TreeLinkNode(1,left_child,right_child,null);
        connect(root);
    }
    public static TreeLinkNode connect(TreeLinkNode root) {
        if(root == null) return null;
        Queue<TreeLinkNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            TreeLinkNode rightNode = null;
            for(int i = q.size(); i > 0; i--) {
                TreeLinkNode cur = q.poll();
                cur.next = rightNode;
                rightNode = cur;
                if(cur.right != null) {
                    q.offer(cur.right);
                    q.offer(cur.left);
                }
            }
        }
        return root;
    }
}
