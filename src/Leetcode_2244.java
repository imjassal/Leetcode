import java.util.*;
public class Leetcode_2244 {
    public static void main(String[] args) {
        int[] tasks = {69,65,62,64,70,68,69,67,60,65,69,62,65,65,61,66,68,61,65,63,60,66,68,66,67,65,63,65,70,69,70,62,68,70,60,68,65,61,64,65,63,62,62,62,67,62,62,61,66,69};
        System.out.println(minimumRounds(tasks));
    }
    public static int minimumRounds(int[] tasks) {
        Arrays.sort(tasks);
        int count = 0;
        int difficultyCount = 1;
        for(int i=0;i<tasks.length-1;i++){
            if(tasks[i]==tasks[i+1])
                difficultyCount++;
            else{
                if(difficultyCount%5==0)
                    count+=(difficultyCount/5)*2;
                else if(difficultyCount%3==0)
                    count+=difficultyCount/3;
                else if(difficultyCount%2==0)
                    count+=difficultyCount/2;
                else
                    return -1;
                difficultyCount=1;
            }
        }
        if(difficultyCount%5==0)
            count+=(difficultyCount/5)*2;
        else if(difficultyCount%3==0)
            count+=difficultyCount/3;
        else if(difficultyCount%2==0)
            count+=difficultyCount/2;
        else
            return -1;
        return count;
    }
}
