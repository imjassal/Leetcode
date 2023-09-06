import java.util.*;
public class Leetcode_863 {
    static Map<Integer, List<Integer>> graph;
    static List<Integer> answer;
    static Set<Integer> visited;
    public static void main(String[] args) {
        TreeNode rightRight = new TreeNode(8);
        TreeNode rightLeft = new TreeNode(0);
        TreeNode right = new TreeNode(1,rightLeft,rightRight);
        TreeNode leftRL = new TreeNode(7);
        TreeNode leftRR = new TreeNode(4);
        TreeNode leftR = new TreeNode(2,leftRL,leftRR);
        TreeNode leftL = new TreeNode(6);
        TreeNode left = new TreeNode(5,leftL,leftR);
        TreeNode root = new TreeNode(3,left,right);
        distanceK(root,left,2);
    }
    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        graph = new HashMap<>();
        buildGraph(root, null);

        answer = new ArrayList<>();
        visited = new HashSet<>();
        visited.add(target.val);

        dfs(target.val, 0, k);

        return answer;
    }

    // Recursively build the undirected graph from the given binary tree.
    private static void buildGraph(TreeNode cur, TreeNode parent) {
        if (cur != null && parent != null) {
            graph.computeIfAbsent(cur.val, k -> new ArrayList<>()).add(parent.val);
            graph.computeIfAbsent(parent.val, k -> new ArrayList<>()).add(cur.val);
        }
        if (cur.left != null) {
            buildGraph(cur.left, cur);
        }
        if (cur.right != null) {
            buildGraph(cur.right, cur);
        }
    }

    private static void dfs(int cur, int distance, int k) {
        if (distance == k) {
            answer.add(cur);
            return;
        }
        for (int neighbor : graph.getOrDefault(cur, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                visited.add(neighbor);
                dfs(neighbor, distance + 1, k);
            }
        }
    }
}
