package Leetcode;

/**
 * Created by hadoop on 17-5-29.
 */
public class CountNumberswithUniqueDigits {
    public static int countNumbersWithUniqueDigits(int n) {
        if(n==0) return 0;
        if(n==1) return 10;
        int res = 9;
        int count = 0;
        for(int i=2;i<=n;i++){
            res *= (9-i+2);
            count +=res;
        }
        return  count;
    }
}
