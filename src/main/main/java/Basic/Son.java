package Basic;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hadoop on 17-5-12.
 */
public class Son extends Father{
    public int b =2;
    private static int a =3;
    public Son(int a){
        System.out.println("son");
    }
    /*public void pub(){
        System.out.println(this.getClass());
    }*/
    public long protecte(){
        System.out.println("son protect");
        return 1;
    }
    private  void ss(){
        System.out.println("son s");
    }
    public static void main(String[] args){
        Father son=new Son(1);
        System.out.println(son.a);

        son.pub();
    }
}
