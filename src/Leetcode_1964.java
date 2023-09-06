public class Leetcode_1964 {
    public static void main(String[] args) {
        int[] obstacles = {1,2,3,2};
        int[] ans = longestObstacleCourseAtEachPosition(obstacles);
        for(int a:ans)
            System.out.print(a+",");

    }
    public static int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int n = obstacles.length;
        int[] longestObstacleCourse = new int[n];
        int[] temps = new int[n];
        int temp = 0;

        for (int i = 0; i < n; i++) {

            int left = 0;
            int right = temp;

            while (left < right) {
                int middle = (left + right) >> 1;

                if (temps[middle] <= obstacles[i]) {
                    left = middle + 1;

                } else {
                    right = middle;
                }
            }

            if (left >= temp || temps[left] > obstacles[i]) {
                temps[left] = obstacles[i];
            }

            if (left == temp) {
                temp++;
            }

            longestObstacleCourse[i] = left + 1;
        }

        return longestObstacleCourse;
    }
}
