import java.util.*;
public class Leetcode_735 {
    public static void main(String[] args) {
        int[] asteroids = {5,10,-5};
        asteroidCollision(asteroids);
    }
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> out = new Stack<>();
        for(int i=0;i<asteroids.length;i++){
            if(out.isEmpty())
                out.push(asteroids[i]);
            else{
                if(out.peek()>0&&asteroids[i]>0||out.peek()<0&&asteroids[i]<0)
                    out.push(asteroids[i]);
                else {
                    while (out.peek() > 0 && asteroids[i] < 0 || out.peek() > 0 && asteroids[i] < 0) {
                        int lastValue = out.peek();
                        int currentVal = asteroids[i];
                        if (Math.abs(lastValue) <= Math.abs(currentVal)) {
                            out.pop();
                            if (out.isEmpty())
                                break;
                        } else {
                            break;
                        }
                    }
                }

            }
        }
        List<Integer> anss = new ArrayList<>();
        int[] ans = new int[out.size()];
        while(!out.isEmpty()){
            anss.add(out.pop());
        }
        int j=0;
        for(int i=anss.size()-1;i>=0;i--){
            ans[j] = anss.get(i);
            j++;
        }
        return ans;
    }
}
