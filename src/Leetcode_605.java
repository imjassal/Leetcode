public class Leetcode_605 {
    public static void main(String[] args) {
        int[] flowerbed = {1,0,0,0,1};
       // int n =1;
        int n1=1;
        //System.out.println(canPlaceFlowers(flowerbed,n));
        //System.out.println("*****");
        System.out.println(canPlaceFlowers(flowerbed,n1));
    }
    public static  boolean canPlaceFlowers(int[] flowerbed, int n) {
        boolean out=false;
        int i=0;
        boolean wasPrevious = false;
        boolean isNext = false;
        int len=flowerbed.length;
        while(n!=0&&i<=len-1){
            if(flowerbed[i]==1){
                wasPrevious = true;
            }
            else
                wasPrevious = false;
            isNext = checkNext(flowerbed,i);

            if(!wasPrevious&& !isNext){
                n--;
                flowerbed[i]=1;
            }

            if(flowerbed[i]==1)
                i+=2;
            else
                i++;
        }
        return n==0;
    }

    static boolean checkNext(int[] flowerbed, int index){
        if(index+1<flowerbed.length){
            if(flowerbed[index+1]==1)
                return true;
        }
        return false;
    }
}
