package Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hadoop on 17-5-29.
 */
public class FourSumII {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int count = 0;
        int sum = 0;
        Map<Integer,Integer> first = new HashMap<Integer,Integer>();

        for(int i = 0;i<A.length;i++){
            for(int j = 0;j<B.length;j++){
                sum = A[i] + B[j];
                if(first.containsKey(sum)){
                    first.put(sum , first.get(sum)+1);
                }else{
                    first.put(sum,1);
                }
            }
        }
        for(int i = 0;i<A.length;i++){
            for(int j = 0;j<B.length;j++){
                sum = 0 - C[i] - D[j];
                if(first.containsKey(sum)){
                    count += first.get(sum);
                }
            }
        }
        return count;
    }
    public static void main(String args[]){
        FourSumII test = new FourSumII();
        int a[]={1,2};
        int b[]={-2,-1};
        int c[]={-1,2};
        int d[]={0,2};
        System.out.println(test.fourSumCount(a,b,c,d));
    }
}
