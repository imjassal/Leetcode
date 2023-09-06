public class Leetcode_73 {
    public static void main(String[] args) {
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        setZeroes(matrix);
    }
    public static void setZeroes(int[][] matrix) {
        boolean col=true;
        int rows=matrix.length;
        int cols=matrix[0].length;
        for(int i=0;i<rows;i++){
            if(matrix[i][0]==0)
                col=false;
            for(int j=0;j<cols;j++){
                if(matrix[i][j]==0)
                    matrix[i][0]=matrix[0][j]=0;
            }
        }
        for(int i=rows-1;i>=0;i--){
            for(int j=cols-1;j>=0;j--){
                if(matrix[i][0]==0 ||matrix[0][j]==0)
                    matrix[i][j]=0;
                if(!col)
                    matrix[i][0]=0;
            }
        }
    }
}
