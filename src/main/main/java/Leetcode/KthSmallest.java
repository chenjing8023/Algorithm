package Leetcode;

import java.util.Stack;

/**
 * Created by hadoop on 17-6-9.
 */
public class KthSmallest {
    public int kthSmallest(TreeNode root, int k) {
        if(k<1)
            return 0;
        int count = k;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode tmp = root;
        while (tmp != null || !stack.isEmpty()){
            while ( tmp != null){
                stack.push(tmp.left);
                tmp = tmp.left;
            }
            tmp = stack.pop();
            count--;
            if(count==0)
                return tmp.val;
            tmp = tmp.right;
        }
        return 0;
    }
}
