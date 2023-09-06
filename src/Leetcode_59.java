public class Leetcode_59 {
    public static void main(String[] args) {
        generateMatrix(3);
    }
    public static int[][] generateMatrix(int n) {
        if(n==1)
            return new int[][]{{1}};
        int[][] matrix = new int[n][n];
        int count = 1;
        int total = n * n;
        int startingRow = 0;
        int endingRow = n - 1;
        int startingCol = 0;
        int endingCol = n - 1;

        while (count <= total) {
            // Traverse top row from left to right
            for (int i = startingCol; count <= total && i <= endingCol; i++) {
                matrix[startingRow][i] = count++;
            }
            startingRow++;

            // Traverse right column from top to bottom
            for (int i = startingRow; count <= total && i <= endingRow; i++) {
                matrix[i][endingCol] = count++;
            }
            endingCol--;

            // Traverse bottom row from right to left
            for (int i = endingCol; count <= total && i >= startingCol; i--) {
                matrix[endingRow][i]=count++;
            }
            endingRow--;

            // Traverse left column from bottom to top
            for (int i = endingRow; count <= total && i >= startingRow; i--) {
                matrix[i][startingCol]=count++;
            }
            startingCol++;
        }
        return matrix;
    }
}
