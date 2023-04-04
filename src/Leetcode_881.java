import java.util.Arrays;

public class Leetcode_881 {
    public static void main(String[] args) {
        int[] people = {5,1,4,2};
        int limit =6;
        System.out.println(numRescueBoats(people,limit));
    }
    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i=0;
        int j=people.length-1;
        int out = 0;
        while(i<=j){
            out++;
            if(people[i]+people[j]<=limit)
                i++;
            j--;
        }
    return out;
    }
}
