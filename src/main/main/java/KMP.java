/**
 * Created by hadoop on 17-4-15.
 */
public class KMP {
    public static int[] getNext(String ps) {

             char[] p = ps.toCharArray();

             int[] next = new int[p.length];

             next[0] = -1;

             int j = 0;

             int k = -1;

             while (j < p.length - 1) {

                 if (k == -1 || p[j] == p[k])
                 {
                     j++;
                     k++;
                     // 如果str[j + 1] == str[k + 1]，回退后仍然失配，所以要继续回退
                     if (p[j] == p[k ])
                     {
                         next[j] = next[k];
                     }
                     else
                     {
                         next[j] = k;
                     }
                 }
                 else
                 {
                     k = next[k];
                 }

             }
             for(int a:next){
                 System.out.print(a+" ");
             }

             return next;

    }
    public static void main(String[] args){
        getNext("abcaac");
    }
}
