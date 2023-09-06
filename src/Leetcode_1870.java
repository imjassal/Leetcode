public class Leetcode_1870 {
    public static void main(String[] args) {
        int[] dist = {1,2,3};
        double hour = 6.0;
        System.out.print(minSpeedOnTime(dist,hour));
    }
    public static int minSpeedOnTime(int[] dist, double hour) {
        int left = 1;
        int right = 10000000;
        int minSpeed = -1;
        while(left<=right){
            int mid = left - (right+left)/2;
            if(isPossible(mid,dist)<=hour){
                minSpeed = mid;
                right = mid-1;
            }
            else
            {
                left = mid+1;
            }
        }
        return minSpeed;
    }

    public static double isPossible(int mid,int[] dist){
        double totalTime = 0.0;
        for(int i=0;i<dist.length;i++){
            double t = (double) dist[i] / (double) mid;
            totalTime += (i == dist.length - 1 ? t : Math.ceil(t));
        }
        return totalTime;
    }
}
