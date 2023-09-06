import java.util.*;
import java.util.stream.*;
import java.text.DecimalFormat;
public class MedianUpdates {
    String[] operations;
    int[] nums;
    List<Integer> data;
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        IntStream.range(0, n).forEach(tItr -> {
            String op = sc.next();
            int num = sc.nextInt();
            boolean ans = modifyList(list,op,num);
            if(ans)
                findMedian(list);
            else
                System.out.println("Wrong!");
        });
    }
    public static boolean modifyList(List<Integer> list,String function, int num){
        if(function.equals("r") && list.isEmpty())
            return false;
        if(function.equals("r")){
            int index = binarySearch(list,num);
            if(index<0)
                return false;
            list.remove(index);
            if(list.isEmpty())
                return false;
        }
        else
            list.add(num);
        Collections.sort(list);
        return true;
    }

    public static int binarySearch(List<Integer> list,int num){
        return Collections.binarySearch(list, num);
    }
    public static void findMedian(List<Integer> list){
        if (list.size() % 2 == 1)
            System.out.println(list.get(list.size()/2));
        else{
            long median = (long)list.get(list.size()/2) + (long)list.get((list.size()/2) - 1);
            if (median % 2 == 0)
                System.out.format("%d%n", median/2);
            else
                System.out.format("%.1f%n", median/2.0);
        }
    }

}