import java.util.List;
import java.util.ArrayList;
public class Leetcode_6430 {
    public static void main(String[] args) {
        circularGameLosers(5,2);
    }
    public static int[] circularGameLosers(int n, int k) {
        int[] visited = new int[n+1];
        visited[1] = 1;
        int m = 1;
        int nextVisit =1;
        boolean flag=true;
        while(flag){
            nextVisit += k*m;
            if(nextVisit%n==0) {
                visited[n]++;
                if (visited[n] > 1)
                    flag = false;
            }
            else {
                nextVisit%=n;
                visited[nextVisit % n]++;
                if (visited[nextVisit] > 1)
                    flag = false;
            }
            m++;
        }
        List<Integer> ans=new ArrayList<>();
        for(int i=1;i<=n;i++)
        {
            if(visited[i]==0)
                ans.add(i);
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }
}
