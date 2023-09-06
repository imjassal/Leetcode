public class Leetcode_785 {
    public static void main(String[] args) {
        int[][] graph = {{1,2,3},{0,2},{0,1,3},{0,2}};
        System.out.print(isBipartite(graph));
    }
    public static boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];

        for (int i = 0; i < n; i++) {
            if (colors[i] == 0 && !dfs(graph, colors, i, 1)) {
                return false;
            }
        }

        return true;
    }

    private static boolean dfs(int[][] graph, int[] colors, int node, int color) {
        if (colors[node] != 0) {
            return colors[node] == color;
        }

        colors[node] = color;

        for (int neighbor : graph[node]) {
            if (!dfs(graph, colors, neighbor, -color)) {
                return false;
            }
        }

        return true;
    }

}
