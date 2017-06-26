import java.util.*;

/**
 * Created by hadoop on 17-3-21.
 */
class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;
    public TreeNode(int x){
        val=x;
    }
}
public class LowestCommonAnCestor {

    public TreeNode node;
    public void buildTree(int[] arr){
        for (int i : arr) {
            insert(i);
        }
    }
    public TreeNode lowest(TreeNode root,TreeNode p,TreeNode q){
        if(root==null || q==null || q==null)
            return null;
        if(root.val>q.val && root.val>p.val)
            return lowest(root.left,p,q);
        if(root.val<q.val && root.val<p.val)
            return lowest(root.right,p,q);
        return root;
    }
    public void insert(int x){
        node=insert(node,x);
    }
    public TreeNode insert(TreeNode root,int x){
        if(root==null)
            return new TreeNode(x);
        if(root.val>=x)
            root.left=insert(root.left,x);
        else
            root.right=insert(root.right,x);
        return root;
    }
    public void levelIterator(TreeNode root){
        if(root==null)
            return;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode current = null;
        queue.offer(root);
        int size=0;
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        while (!queue.isEmpty()){
            size = queue.size();

            List<Integer> num = new ArrayList<Integer>();
            for(int i=0;i<size;i++){
                current = queue.peek();
                num.add(current.val);

            }

            list.add(num);
            if(current.left != null){
                queue.offer(current.left);
            }
            if(current.right != null){
                queue.offer(current.right);
                
            }
        }
        for(List<Integer> tmp : list){
            for(Integer val : tmp){
                System.out.print(val+" ");
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        int arr[]={20,10,30,5,15,25,40,12,18};
        LowestCommonAnCestor lcn = new LowestCommonAnCestor();
        lcn.buildTree(arr);
        lcn.levelIterator(lcn.node);

    }
}
