package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hadoop on 17-6-5.
 */
public class CombinationSumII {
    private List<List<Integer>> result = new ArrayList<List<Integer>>();
    private int[] candidates;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<Integer> list = new ArrayList<Integer>();
        if(candidates == null || candidates.length==0)
            return result;
        Arrays.sort(candidates);
        this.candidates = candidates;
        combine(list,0,target);
        return result;
    }
    public void combine(List<Integer> list, int start, int target){

        if(target == 0){

            List<Integer> cur = new ArrayList<Integer>(list);
            result.add(cur);
            return;
        }
        if(target<0 || start>=candidates.length)
            return;
        for(int i = start; i<candidates.length;i++){
            if(i>start && candidates[i] == candidates[i-1]) continue;
            list.add(candidates[i]);
            combine(list,i+1,target-candidates[i]);
            list.remove(list.size()-1);
        }
    }
    public static void main(String[] args){
        int num[] = {1};
        CombinationSumII test = new CombinationSumII();
        test.combinationSum2(num,1);
    }
}
