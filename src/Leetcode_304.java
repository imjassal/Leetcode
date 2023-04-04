public class Leetcode_304 {
    public static void main(String[] args) {
        int[][] matrix = {{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5},{4, 1, 0, 1, 7},{1, 0, 3, 0, 5}};
        int row1=2, col1=1, row2 = 4, col2=3;
        NumMatrix obj = new NumMatrix(matrix);
        int param_1 = obj.sumRegion(row1, col1, row2, col2);
        System.out.println(param_1);
    }
}
class NumMatrix {
    private int[][] data;
    public NumMatrix(int[][] matrix) {
        if(matrix.length==0||matrix[0].length==0)
            return;
//        Using just normal row caching
//        data=new int[matrix.length][matrix[0].length+1];
//        for(int r=0;r<matrix.length;r++){
//            for(int c=0;c<matrix[0].length;c++){
//                data[r][c+1]=data[r][c]+matrix[r][c];
//            }
//        }
//        Using smart Caching
        data=new int[matrix.length+1][matrix[0].length+1];
        for(int r=0;r<matrix.length;r++){
            for(int c=0;c<matrix[0].length;c++){
                //        Sum(ABCD)=Sum(OD)−Sum(OB)−Sum(OC)+Sum(OA)
                data[r+1][c+1]=data[r+1][c]+data[r][c+1]+matrix[r][c]-data[r][c];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        //        Sum(ABCD)=Sum(OD)−Sum(OB)−Sum(OC)+Sum(OA)
        return data[row2+1][col2+1]-data[row1][col2+1]-data[row2+1][col1]+data[row1][col1];
    }
}