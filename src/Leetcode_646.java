import java.util.*;
public class Leetcode_646 {
    public static void main(String[] args) {
        int[][] pairs = {{1,2},{2,3},{3,4}};
        System.out.println(findLongestChain(pairs));
    }
    public static int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(pair1,pair2)->Integer.compare(pair1[1],pair2[0]));
        int count = 0,localCount = 0;
        for(int i=1;i<pairs.length;i++){
            if(pairs[i-1][1]<pairs[i][0])
                localCount++;
        }
        return localCount+1;
    }
}
