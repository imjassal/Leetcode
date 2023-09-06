import java.util.*;
public class Leetcode_347 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4};
        topKFrequent(nums, 2);
    }

    public static int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        map = sortValues(map);
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (i < k)
                ans[i] = entry.getKey();
            if (i == k)
                break;
            i++;
        }
        return ans;
    }

    public static HashMap sortValues(HashMap map) {
        SortedSet<Integer> list = new TreeSet<>(map.values());
        HashMap sortedHashMap = new LinkedHashMap();
        for (Iterator it = list.iterator(); it.hasNext(); ) {
            Map.Entry entry = (Map.Entry) it.next();
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }
        return sortedHashMap;
    }
}