package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by hadoop on 17-4-22.
 */
public class FindBottomLeftTreeValue {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int size=0;
        int result =0;
        while (queue.size()>0){
            size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode treeNode = queue.poll();
                if(i==0){
                    result = treeNode.val;
                }
                if(treeNode.left!=null){
                    queue.offer(treeNode.left);
                }
                if(treeNode.right!=null){
                    queue.offer(treeNode.right);
                }
            }
        }
        System.out.println(result);
        return result;
    }
    public void buildTree(){
        TreeNode root = new TreeNode(10);
        TreeNode left = new TreeNode(4);
        TreeNode right = new TreeNode(3);
        root.left=left;
        root.right = right;
        TreeNode left1 = new TreeNode(6);
        TreeNode right1 = new TreeNode(7);
        left.left=left1;
        left.right = right1;
        TreeNode left2 = new TreeNode(45);
        TreeNode right2 = new TreeNode(2);
        right.left=left2;
        right.right = right2;
        TreeNode left3 = new TreeNode(7);
        TreeNode right3 = new TreeNode(8);
        right2.left=left3;
        right2.right=right3;
        findBottomLeftValue(root);
    }
    public static void main(String[] args){
        FindBottomLeftTreeValue root = new FindBottomLeftTreeValue();
        root.buildTree();
    }
}
