import java.util.*;
public class Leetcode_207 {
    public static void main(String[] args) {
        int[][] prerequisites = {{1,0},{1,2},{0,1}};
        canFinish(3,prerequisites);
    }
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
//        Map<Integer,List<Integer>> pre = new HashMap<>();
//        for(int i=0;i<prerequisites.length;i++){
//            int course = prerequisites[i][0];
//            int preCourse = prerequisites[i][1];
//            pre.computeIfAbsent(course, k -> new ArrayList<>()).add(preCourse);
//        }
//        return true;
        int[] indegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>(numCourses);

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            adj.get(prerequisite[1]).add(prerequisite[0]);
            indegree[prerequisite[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        // Push all the nodes with indegree zero in the queue.
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int nodesVisited = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            nodesVisited++;

            for (int neighbor : adj.get(node)) {
                // Delete the edge "node -> neighbor".
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return nodesVisited == numCourses;
    }

}
