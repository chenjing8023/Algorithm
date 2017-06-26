import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.*;

/**
 * Created by hadoop on 17-4-5.
 */
class Node{
    int val;
    Node left;
    Node right;
    public Node(int val){
        this.val=val;
    }
}
class MyCallable implements Callable {

     public Integer call() throws Exception {
                 int sum    = 0;
                 // 执行任务
                 for (int i=0; i<100; i++)
                         sum += i;
                 //return sum;
                 return Integer.valueOf(sum);
             }
 }
public class LAC_RMQ {
    public int dp[][];
    public static int[] deth=new int[100];
    public static int[] first=new int[100];
    public static int[] vec=new int[100];
    public void dfs(int val,int deth){}
    public static void main (String args[]) {
        /*Comparator<Map.Entry<String, Integer>> comparator=new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue()-o2.getValue();
            }
        };
        Map<String,Integer> map=new TreeMap<String,Integer>();
        map.put("a",1);
        map.put("b",2);
        map.put("c",3);
        List<Map.Entry<String,Integer>> list= new ArrayList<Map.Entry<String,Integer>>(map.entrySet());
        Collections.sort(list, comparator);
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        map.put("d",4);

        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }*/
        HashMap<String,String> a=new HashMap<String, String>();
        a.put("a","a");
        a.get("a");

    }


}
