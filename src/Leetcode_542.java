import java.util.*;
public class Leetcode_542 {
    public static void main(String[] args) {
        int[][] mat ={{0,0,0},{0,1,0},{1,1,1}};
        int[][] out = updateMatrix(mat);
        for(int i=0;i<mat.length;i++) {
            for (int j = 0; j < mat.length; j++) {
                System.out.print(mat[i][j]);
            }
            System.out.println();
        }
    }

    public static int[][] updateMatrix(int[][] mat) {
        int[] DIR = new int[]{0, 1, 0, -1, 0};
        int m = mat.length, n = mat[0].length; // The distance of cells is up to (M+N)
        Queue<int[]> q = new ArrayDeque<>();
        for (int r = 0; r < m; ++r)
            for (int c = 0; c < n; ++c)
                if (mat[r][c] == 0) q.offer(new int[]{r, c});
                else mat[r][c] = -1; // Marked as not processed yet!

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0], c = curr[1];
            for (int i = 0; i < 4; ++i) {
                int nr = r + DIR[i], nc = c + DIR[i+1];
                if (nr < 0 || nr == m || nc < 0 || nc == n || mat[nr][nc] != -1) continue;
                mat[nr][nc] = mat[r][c] + 1;
                q.offer(new int[]{nr, nc});
            }
        }
        return mat;
    }
}
