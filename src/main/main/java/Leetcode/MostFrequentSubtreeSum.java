package Leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by hadoop on 17-4-29.
 */
public class MostFrequentSubtreeSum {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public void order(TreeNode root){
        if(root==null)
            return;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (stack.size() > 0){
            TreeNode node = stack.peek();
            if(node.left!=null){
                stack.push(node.left);
            }else if(node.right!=null){
                stack.push(node.right);
            }
        }
    }
    public Map<Integer,Integer> result = new HashMap<Integer, Integer>();
    public int max_count = 0;
    public int dfs(TreeNode root){
        if(root == null)
            return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        int sum =root.val + left + right;
        int count = result.getOrDefault(sum,0);
        max_count = count > max_count ? count : max_count;
        result.put(sum, count);
        return sum;
    }
    public static void main(String[] args){

    }
}
