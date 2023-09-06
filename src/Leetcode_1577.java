import java.util.*;
import java.util.stream.Collectors;

public class Leetcode_1577 {
    public static void main(String[] args) {
        List<List<Integer>> vertices = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        vertices.add(l);
        l = new ArrayList<>();
        l.add(3);
        l.add(2);
        vertices.add(l);
        l = new ArrayList<>();
        l.add(1);
        l.add(3);
        vertices.add(l);
        l = new ArrayList<>();
        l.add(1);
        l.add(0);
        vertices.add(l);
        l = new ArrayList<>();
        l.add(0);
        l.add(2);
        vertices.add(l);
        l = new ArrayList<>();
        l.add(0);
        l.add(3);
        vertices.add(l);
        findSmallestSetOfVertices(4,vertices);
    }
    public static List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean[] existsIncoming = new boolean[n];
        List<Integer> outgoing = new ArrayList<>();
        for(int i=0;i<edges.size();i++){
            existsIncoming[edges.get(i).get(1)]=true;
        }
        for(int i=0;i<edges.size();i++){
            if(!existsIncoming[edges.get(i).get(0)]){
                outgoing.add(edges.get(i).get(0));
                existsIncoming[edges.get(i).get(0)]=true;
            }
        }
        return outgoing;
    }
}
