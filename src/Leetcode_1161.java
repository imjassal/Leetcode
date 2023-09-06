import java.util.*;

public class Leetcode_1161 {
    public static void main(String[] args) {
        TreeNode leftNode = new TreeNode(-32127);
        TreeNode leftLeftNode = new TreeNode(98693);
        TreeNode leftRightNode = new TreeNode(-89388,null,leftNode);
        TreeNode rightnode = new TreeNode(10250,leftLeftNode,leftRightNode);
        TreeNode root = new TreeNode(989,null,rightnode);
        System.out.print(maxLevelSum(root));

    }
    public static int maxLevelSum(TreeNode root) {
        int answer = Integer.MIN_VALUE;
        if (root == null)
            return answer;

        int level = 0;
        answer = bfsHelper(root, answer, level);

        return answer;
    }
    public static int bfsHelper(TreeNode root, int answer, int level)
    {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int ansLevel = 0;
        while (!q.isEmpty())
        {
            int size = q.size();
            int subAns = 0;
            int i = 0;

            for (i=0; i<size; i++)
            {
                TreeNode temp = q.poll();
                subAns+=temp.val;
                if (temp.left!=null)
                    q.add(temp.left);

                if (temp.right!=null)
                    q.add(temp.right);
            }
            level++;
            if(answer<subAns){
                answer = subAns;
                ansLevel = level;
            }

        }
        return ansLevel;
    }
}
