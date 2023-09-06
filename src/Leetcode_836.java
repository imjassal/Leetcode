import java.util.*;
public class Leetcode_836 {
    public static void main(String[] args) {
        int[][] dislikes = {{1,2},{1,3},{3,4}};
        System.out.print(possibleBipartition(4,dislikes));

    }
    public static boolean possibleBipartition(int n, int[][] dislikes) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : dislikes) {
            int a = edge[0], b = edge[1];
            adj.computeIfAbsent(a, value -> new ArrayList<Integer>()).add(b);
            adj.computeIfAbsent(b, value -> new ArrayList<Integer>()).add(a);
        }
        int[] color = new int[n+1];
        Arrays.fill(color,-1);
        for(int i=1;i<color.length;i++){
            if(color[i]==-1){
                if(!bfs(adj,i,color))
                    return false;
            }
        }
        return true;
    }

    public static boolean bfs(Map<Integer, List<Integer>> adj,int index,int[] color){
        Queue<Integer> q=new LinkedList<>();
        q.offer(index);
        color[index]=0;
        while(!q.isEmpty()){
            int edge = q.poll();
            if(!adj.containsKey(edge))
                continue;
            for(int neighbour: adj.get(edge)){
                if(color[neighbour]==color[edge])
                    return false;
                if(color[neighbour]==-1){
                    color[neighbour] = 1-color[edge];
                    q.add(neighbour);
                }
            }
        }
        return true;
    }
}
