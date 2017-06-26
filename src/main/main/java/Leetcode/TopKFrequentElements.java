package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hadoop on 17-5-22.
 */
public class TopKFrequentElements {
    public static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int n : nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        List<Integer> fren[] = new List[nums.length+1];
        for(int key:map.keySet()){
            if(fren[map.get(key)]==null){
                fren[map.get(key)] = new ArrayList<Integer>();
            }
            fren[map.get(key)].add(key);
        }

        List<Integer> result= new ArrayList<Integer>();
        int count=0;
        for(int i = fren.length-1;i>0;i--){
            if(fren[i]!=null &&  fren[i].size()>0){
                if(count<k){
                    result.addAll(fren[i]);
                    count+=fren[i].size();
                }
                if(count==k)
                    break;

            }

        }
        return result;
    }
    public static void main(String[] args){
        int test[] ={1,2};
        topKFrequent(test,2);
    }
}
