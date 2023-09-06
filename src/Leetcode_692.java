import java.util.*;
public class Leetcode_692 {
    public static void main(String[] args) {
        String[] words = {"i","love","leetcode","i","love","coding"};
        int k = 3;
        List<String> ans = topKFrequent(words,k);
        for(String an:ans)
            System.out.println(an);
    }
    public static List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map = new HashMap<>();
        PriorityQueue<Pair> pq= new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if(o1.freq!=o2.freq)
                    return o1.freq-o2.freq;
                return o2.val.compareTo(o1.val);
            }
        });
        for(String w:words)
            map.put(w,map.getOrDefault(w,0)+1);
        for(String key : map.keySet()){
            if(pq.size()<k){
                pq.add(new Pair(map.get(key),key));
            }else{
                if(pq.peek().freq<map.get(key)){
                    pq.remove();
                    pq.add(new Pair(map.get(key),key));
                }else if(pq.peek().freq==map.get(key)){
                    pq.add(new Pair(map.get(key),key));
                }
            }
        }
        while(pq.size()>k){
            pq.remove();
        }
        List<String> ans = new ArrayList<>();
        while(pq.size()>0){
            ans.add(0,pq.remove().val);
        }
        return ans;
    }
    static class Pair{
        int freq;
        String val;
        Pair(int freq,String val)
        {
            this.freq=freq;
            this.val = val;
        }
    }
}
