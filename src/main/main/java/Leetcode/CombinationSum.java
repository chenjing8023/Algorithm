package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by hadoop on 17-6-3.
 */
public class CombinationSum {
    private List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<List<Integer>>();
        List<Integer> store = new ArrayList<Integer>();
        Arrays.sort(candidates);
        comboine(candidates,store,0,target);
        for(List<Integer> i :result){
            for(Integer t : i)
                System.out.print(t+"  ");
            System.out.println();
        }

        return result;
    }
    public void comboine(int[] candidates, List<Integer> store,int start,int target){
        if(target == 0){
            List<Integer> a = new ArrayList<Integer>(store);
            result.add(a);
        }else{
            for(int i = start;i<candidates.length && candidates[i]<=target;i++){
                store.add(candidates[i]);
                comboine(candidates,store,i,target-candidates[i]);
                store.remove(store.size()-1);
            }
        }

    }
    public static void main(String[] args){
        int[] candidates = {2,3,6,7};
        CombinationSum sum = new CombinationSum();
        sum.combinationSum(candidates,7);
        /*List<Integer> store = new ArrayList<Integer>();
        store.add(candidates[0]);
        store.add(candidates[0]);
        store.add(candidates[1]);
        store.remove(new Integer(candidates[1]));*/
    }
}
