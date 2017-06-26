package Leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by hadoop on 17-6-5.
 */
public class MaximumXORofTwoNumbersinanArray {
    class TreeNode{
        TreeNode next[] ;
        public TreeNode(){
            next = new TreeNode[2];
        }
    }
    public int getMax(int nums[]){
        TreeNode root = new TreeNode();
        for(int num : nums){
            TreeNode tmp = root;
            for(int i=31;i>=0;i--){
                int t = (num>>>i) & 1;
                if(tmp.next[t] == null){
                    tmp.next[t] = new TreeNode();
                }
                tmp = tmp.next[t];
            }
        }

        int max = 0;
        for(int num : nums){
            TreeNode node = root;
            int sum = 0;
            for(int i=31;i>=0;i--){
                int t = (num>>>i) & 1;
                if(node.next[t^1] != null){
                    node = node.next[t^1];
                    sum += 1<<31;
                }else{
                    node = node.next[t];
                }
            }
            max = Math.max(sum,max);
        }
        return max;
    }
    public int findMaximumXOR(int[] nums) {
        int max = 0;
        int prefix = 0;
        for(int i = 31;i>=0;i--){
            Set<Integer> set = new HashSet<Integer>();
            prefix = prefix | 1<<i;
            for(int num : nums){
                set.add(num & prefix);
            }

            int possible = max | 1<<i;
            for(int num : nums){
                if(set.contains(possible ^ num)){
                    max = possible;
                    break;
                }

            }

        }
        return max;
    }

}
