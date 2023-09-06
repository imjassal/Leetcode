public class Leetcode_98 {
    public static void main(String[] args) {
        TreeNode left = new TreeNode(4);
        TreeNode rightLeft = new TreeNode(3);
        TreeNode rightRight = new TreeNode(7);
        TreeNode right = new TreeNode(6,rightLeft,rightRight);
        TreeNode root = new TreeNode(5,left,right);
//        TreeNode left = new TreeNode(1);
//        TreeNode root = new TreeNode(1,left,null);
        System.out.println(isValidBST(root));
    }
    public static boolean isValidBST(TreeNode root) {
            return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        public static boolean isValidBST(TreeNode root, long minVal, long maxVal) {
            if (root == null) return true;
            if (root.val >= maxVal || root.val <= minVal) return false;
            return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
        }
    }
