public class Leetcode_1372 {
    public static void main(String[] args) {
        //[1,null,1,1,1,null,null,1,1,null,1,null,null,null,1,null,1]
        TreeNode leftLeftRight = new TreeNode(1,null,null);
        TreeNode oneMore = new TreeNode(1,null,null);
        TreeNode more = new TreeNode(1,null,oneMore);
        TreeNode leftLeftLeft = new TreeNode(1,null,more);
        TreeNode leftRight = new TreeNode(1,leftLeftLeft,leftLeftRight);
        TreeNode left = new TreeNode(1,null,null);
        TreeNode right = new TreeNode(1,left,leftRight);
        TreeNode root = new TreeNode(1,null,right);
        System.out.println(longestZigZag(root));
    }
    static int longestPath = 0;
    static int subLongestPath = 0;
//    public static int longestZigZag(TreeNode root) {
//        if(root==null)
//            return 0;
//        zigzag(root,"left");
//        zigzag(root,"right");
//        return longestPath-1;
//    }
    public static void zigzag(TreeNode root,String direction){
        if(root==null){
            longestPath = Math.max(subLongestPath,longestPath);
            subLongestPath=0;
            return;
        }
        if(direction=="left"&&root.left!=null){
            subLongestPath++;
            zigzag(root.left,"right");
        }
        if(direction=="right"&&root.right!=null){
            subLongestPath++;
            zigzag(root.right,"left");
        }
        else {
            subLongestPath++;
            longestPath = Math.max(subLongestPath,longestPath);
            subLongestPath = 0;
            return;
        }

    }
        static int pathLength = 0;
        private static void dfs(TreeNode node, boolean goLeft, int steps) {
            if (node == null) {
                return;
            }
            pathLength = Math.max(pathLength, steps);
            if (goLeft) {
                dfs(node.left, false, steps + 1);
                dfs(node.right, true, 1);
            } else {
                dfs(node.left, false, 1);
                dfs(node.right, true, steps + 1);
            }
        }

        public static int longestZigZag(TreeNode root) {
            dfs(root, false, 0);
            dfs(root, true, 0);
            return pathLength;
        }
    }
