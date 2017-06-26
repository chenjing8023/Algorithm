/**
 * Created by hadoop on 17-4-21.
 */
public class BeautifuArrangement {
    private int count=0;
    public int countArrangement(int N) {
        boolean[] flag = new boolean[N+1];
        get(N,1,flag);

        return count;
    }
    public void get(int n,int level,boolean[] flag){
        if(level>n){
            count++;
            return;
        }

        for(int i=1;i<=n;i++){
            if(!flag[i] && (i%level==0 || level%i==0)){
                flag[i]=true;
                get(n,level+1,flag);
                flag[i]=false;
            }
        }
    }
    public static void main(String[] args){
        BeautifuArrangement test = new BeautifuArrangement();
        System.out.println(test.countArrangement(2));
    }
}
