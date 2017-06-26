package Basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created by hadoop on 17-6-2.
 */
public class Oom {
    public static void test(){
        Oom t = new Oom();
    }
    public static void main(String args[]){
        List<Oom> list = new ArrayList<Oom>();
        System.out.print("a");
        /*while (true){
            test();
        }*/

    }

}
