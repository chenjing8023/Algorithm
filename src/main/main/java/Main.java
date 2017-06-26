import java.util.*;

public  class Main{
    class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int x) { val = x; }
    }
    public List<Integer> right(TreeNode root){
        if(root == null)
            return null;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<Integer> result = new ArrayList<Integer>();
        queue.offer(root);
        int number = 0;
        int leave = 1;
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(leave == 1){
                result.add(node.val);
            }
            leave--;
            if(node.left != null){
                queue.offer(node.left);
                number++;
            }
            if(node.right != null){
                queue.offer(node.right);
                number++;
            }
            if(leave == 0){
                leave = number;
                number = 0;
            }
        }
        for(Integer i :result)
            System.out.println(i);
        return result;
    }
    public void build(){
        TreeNode root = new TreeNode(10);
        TreeNode left = new TreeNode(9);
        TreeNode leftleft = new TreeNode(8);
        TreeNode right = new TreeNode(7);
        root.left = left;
        root.right = right;
        left.left = leftleft;
        right(root);
    }
    public static void main(String args[]){
        Main test = new Main();
        test.build();
        String a = new String();
    }
}