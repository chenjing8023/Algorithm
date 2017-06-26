package Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by hadoop on 17-5-28.
 */
public class BinaryTreeInorderTraversal {
    class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        public TreeNode(int x){val=x;}
    }
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> node = new Stack<TreeNode>();
        TreeNode tmp = root;
        while(tmp !=null || !node.isEmpty()){
            while (tmp != null){
                node.push(tmp);
                result.add(tmp.val);
                System.out.println(tmp.val);
                tmp = tmp.left;
            }
            tmp = node.pop();


            tmp = tmp.right;

        }
        return result;
    }
    public void build(){
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(9);
        TreeNode leftleft = new TreeNode(3);
        TreeNode right = new TreeNode(2);
        //root.left = left;
        root.right = right;
        right.left = leftleft;

        inorderTraversal(root);
    }
    public static void main(String args[]){
         BinaryTreeInorderTraversal test = new BinaryTreeInorderTraversal();
        test.build();
    }
}
