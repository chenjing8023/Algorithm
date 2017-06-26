package Basic;

import java.util.HashMap;

/**
 * Created by hadoop on 17-5-12.
 */
public class Father {
    public static int a=1;
    public Father(){
        System.out.println("Father init");
    }
    public void pub(){
        System.out.println(this.getClass());
    }
    protected long protecte(){
        System.out.println("Father protect");
        return 2;
    }
    void defaulted(){
        System.out.println("Father default");
    }
    private void privated(){
        System.out.println("Father protect");
    }
    private void ss(){
        System.out.println("Father s");
    }
}
