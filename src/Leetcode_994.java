public class Leetcode_994 {
    static int maxTime = 0;
    public static void main(String[] args) {
        //int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        int[][] grid = {{2,1,1},{0,1,1},{1,0,1}};
        //int[][] grid = {{1,2}};
        //int[][] grid ={{2,0,1,1,1,1,1,1,1,1},{1,0,1,0,0,0,0,0,0,1},{1,0,1,0,1,1,1,1,0,1},{1,0,1,0,1,0,0,1,0,1},{1,0,1,0,1,0,0,1,0,1},{1,0,1,0,1,1,0,1,0,1},{1,0,1,0,0,0,0,1,0,1},{1,0,1,1,1,1,1,1,0,1},{1,0,0,0,0,0,0,0,0,1},{1,1,1,1,1,1,1,1,1,1}};
        System.out.println(orangesRotting(grid));
    }
    public static int orangesRotting(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        boolean oneExists = false;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1)
                    oneExists = true;
            }
        }
        if(!oneExists)
            return 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==2&&visited[i][j]==false)
                    maxTime++;
                    dfs(grid,visited,i,j);
            }

        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1)
                    return -1;
            }

        }
        int ver = Math.min(grid.length,grid[0].length);
        return maxTime-2;
    }

    public static void dfs(int[][] grid, boolean[][] visited,int i, int j){
        if(i<0 || j<0 || i>grid.length || j>grid[0].length || visited[i][j]==true){
            return;
        }

        else if(grid[i][j]==0)
        {
            visited[i][j]=true;
            return;
        }
        else{
            grid[i][j]=2;
            visited[i][j]=true;
        }
        if(i>0) dfs(grid,visited,i-1,j);
        if(j>0) dfs(grid,visited,i,j-1);
        if(i<grid.length-1)  dfs(grid,visited,i+1,j);
        if(j<grid[0].length-1) dfs(grid,visited,i,j+1);
        maxTime+=1;
    }
}
