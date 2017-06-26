import java.util.Comparator;

/**
 * Created by hadoop on 17-3-26.
 */
public class Father implements Comparable{
    private int age;
    public int name;



    public int compareTo(Object father){
        System.out.println("father compare");
        return 1;
    }
    public static void main(String args[]){

    }
}
