package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hadoop on 17-6-5.
 */
public class CombinationSumIII {
    private List<List<Integer>> result = new ArrayList<List<Integer>>();
    private int n ;
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> cur = new ArrayList<Integer>();
        if(k<1 || n <1)
            return result;
        this.n = n;
        combine(cur,k,1,0);

        return result;
    }
    public void combine(List<Integer> cur,int k,int start,int sum){
        if(sum > n || k<0)
            return;
        if(sum == n && k==0){
            result.add(new ArrayList<Integer>(cur));
        }
        for(int i = start;i<=9;i++){
            cur.add(i);
            combine(cur,k-1,i+1,sum+i);
            cur.remove(cur.size()-1);
        }
    }
    public static void main(String[] args){
        CombinationSumIII test = new CombinationSumIII();
        test.combinationSum3(3,7);
    }
}
