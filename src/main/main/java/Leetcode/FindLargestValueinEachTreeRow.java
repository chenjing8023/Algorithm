package Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by hadoop on 17-4-20.
 */
public class FindLargestValueinEachTreeRow {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int size = 0;
        int max = 0;
        while (queue.size()>0){
            size = queue.size();
            max = queue.peek().val;
            for(int i=0;i<size;i++){
                TreeNode tmp = queue.poll();
                System.out.print(tmp.val+" ");
                if(tmp.val>max){
                    max=tmp.val;
                }
                if(tmp.left!=null)
                    queue.offer(tmp.left);
                if(tmp.right!=null)
                    queue.offer(tmp.right);
            }
            result.add(max);
            System.out.println();
        }
        /*for(int i : result)
            System.out.println(i);*/
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
        largestValues(root);
    }
    public static void main(String[] args){
        FindLargestValueinEachTreeRow root = new FindLargestValueinEachTreeRow();
        root.buildTree();
    }
}
