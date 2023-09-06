import java.util.*;
public class Leetcode_137 {
    public static void main(String[] args) {
        int[] nums ={1,1,3,1};
        System.out.print(singleNumber(nums));
    }
    public static int singleNumber(int[] nums) {
        if(nums.length==1)
            return nums[0];
        HashMap<Integer,Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            set.add(nums[i]);
            if(map.get(nums[i])>1)
                set.remove(nums[i]);
        }
        Optional<Integer> os = set.stream().findFirst();
        return set.stream().findFirst().get();
    }
}
