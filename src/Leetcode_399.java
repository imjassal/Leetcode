import java.util.*;
public class Leetcode_399 {
    private static Map<String, String> p;
    private static Map<String, Double> w;
    public static void main(String[] args) {
        double[] values = {1.5,2.5,5.0};
        List<String> inner = new ArrayList<>();
        List<List<String>> equations = new ArrayList<>();
        List<List<String>> queries = new ArrayList<>();
        inner.add("a");
        inner.add("b");
        equations.add(inner);
        inner = new ArrayList<>();
        inner.add("b");
        inner.add("c");
        equations.add(inner);
        inner = new ArrayList<>();
        inner.add("bc");
        inner.add("cd");
        equations.add(inner);
        inner = new ArrayList<>();
        inner.add("a");
        inner.add("c");
        queries.add(inner);
        inner = new ArrayList<>();
        inner.add("c");
        inner.add("b");
        queries.add(inner);
        inner = new ArrayList<>();
        inner.add("bd");
        inner.add("cb");
        queries.add(inner);
        calcEquation(equations,values,queries);
    }
    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = equations.size();
        p = new HashMap<>();
        w = new HashMap<>();
        for (List<String> e : equations) {
            p.put(e.get(0), e.get(0));
            p.put(e.get(1), e.get(1));
            w.put(e.get(0), 1.0);
            w.put(e.get(1), 1.0);
        }
        for (int i = 0; i < n; ++i) {
            List<String> e = equations.get(i);
            String a = e.get(0), b = e.get(1);
            String pa = find(a), pb = find(b);
            if (Objects.equals(pa, pb)) {
                continue;
            }
            p.put(pa, pb);
            w.put(pa, w.get(b) * values[i] / w.get(a));
        }
        int m = queries.size();
        double[] ans = new double[m];
        for (int i = 0; i < m; ++i) {
            String c = queries.get(i).get(0), d = queries.get(i).get(1);
            ans[i] = !p.containsKey(c) || !p.containsKey(d) || !Objects.equals(find(c), find(d))
                    ? -1.0
                    : w.get(c) / w.get(d);
        }
        return ans;
    }

    private static String find(String x) {
        if (!Objects.equals(p.get(x), x)) {
            String origin = p.get(x);
            p.put(x, find(p.get(x)));
            w.put(x, w.get(x) * w.get(origin));
        }
        return p.get(x);
    }
}