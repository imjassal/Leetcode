import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Test {
    public static void main(String[] args) {
        //System.out.println(method());
        MyInnerClass inner=new Test().new MyInnerClass();
    }
    private class MyInnerClass{

    }
}

