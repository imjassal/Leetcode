public class Leetcode_129 {
    public static void main(String[] args) {
        TreeNode left=new TreeNode(5,null,null);
        TreeNode right_1=new TreeNode(6);
        TreeNode right=new TreeNode(1,null,right_1);
        TreeNode head=new TreeNode(1,left,right);
        int ans=sumNumbers(head);
        System.out.println(ans);
    }
    static int sum=0;
    public static int sumNumbers(TreeNode root) {
        int pathSum=0;
        helper(root,pathSum);
        return sum;
    }

    static void helper(TreeNode root,int pathSum){
        if(root==null){
            pathSum=0;
            return;
        }
        pathSum=pathSum*10+root.val;
        if(root.left==null && root.right==null){
            sum+=pathSum;
        }
        helper(root.left,pathSum);
        helper(root.right,pathSum);
    }
}
