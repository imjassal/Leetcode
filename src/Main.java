import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello world!");
//        DisplayA arr1 = new DisplayA();
//        DisplayB arr2 = new DisplayB();
//        arr1.x=0;
//        arr2.x=0;
//        arr1.cal(2);
//        arr2.cal(2);
//        System.out.println(arr1.x+" "+arr2.x);
//        String s1="Hello ";
//        s1+="World";
//        String s2="Hello";
//        s2+=" ";
//        s2+="World";
//        String s3=s1.intern();
//        String s4=s2.intern();
//        System.out.print(s3==s4);
//        System.out.print(s3.equals(s4));
//        Integer number = 10;
//        number++;
//        assert  number>=0;
//        Animals[] animals = Animals.values();
//        Map<Color,String> map= new HashMap<>();
//        map.put(new Color("Red"),"Red");
//        map.put(new Color("Blue"),"Blue");
//        map.put(new Color("Green"),"Green");
//        System.out.print(map.size());
//        System.out.print(map.get(new Color("Red")));
//        Comparator<Integer> numberComparator = (num1,num2)->num1.compareTo(num2);
//        Integer[] arr = {1,4,3,2,2};
//        Arrays.sort(arr,numberComparator);
//        for(Integer a:arr)
//        Main main = new Main();
//        try {
//        main.divide(2,0);
//        } catch (ArithmeticException re) {
//            System.out.print("arr ex ");
//        }catch (RuntimeException re) {
//            System.out.print("Runtime ex ");
//        } catch (Exception e) {
//            System.out.print(" Exception");
//        } finally{
//            System.out.print(" Finally end");
//        }
        Labra l = new Labra();
        printValue(l);
    }
//    static void printValue(Animal obj){
//        System.out.println("first");
//    }
//    static void printValue(Dog obj){
//        System.out.println("second");
//    }
    static void printValue(Object obj){
        System.out.println("third");
    }
    public void divide(int a, int b){
        try {
        int c=a/b;
        }
        finally {
            System.out.print("finally");
        }
    }
}

enum Animals{
    LION,DOG,COW
}
class Color{
    private String name;
    public Color(String name){
        this.name=name;
    }

    @Override
    public boolean equals(Object obj) {
        return true;
    }

    @Override
    public int hashCode() {
        return 1;
    }
}
interface calc{
    void cal(int item);
}
class DisplayA implements calc{
    int x;

    public void cal(int item) {
     this.x=item*item;
    }
}

class DisplayB implements calc{
    int x;

    public void cal(int item) {
        this.x=item/item;
    }
}

class Animal{

}
class Dog extends Animal{

}
class Labra extends Dog{

}