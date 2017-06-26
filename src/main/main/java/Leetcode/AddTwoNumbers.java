package Leetcode;

/**
 * Created by hadoop on 17-5-22.
 */

public class AddTwoNumbers {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode tmp = head;
        int res = 0;
        int sum = 0;
        while (l1 != null || l2 !=null){
            if(l1 != null){
                res += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                res += l2.val;
                l2 = l2.next;
            }
            tmp.next = new ListNode(res%10);
            res = res/10;
            tmp = tmp.next;
        }
        if(res ==1){
            tmp.next = new ListNode(1);
        }
        return head;
    }

    public void sum(){
        ListNode a1 = new ListNode(2);
        ListNode a2 = new ListNode(4);
        ListNode a3 = new ListNode(3);
        a1.next = a2;
        a2.next = a3;
        ListNode b1 = new ListNode(4);
        ListNode b2 = new ListNode(6);
        //ListNode b3 = new ListNode(4);
        b1.next = b2;
        //b2.next = b3;
        addTwoNumbers(a1,b1);
    }
    public static void main(String[] args){
        AddTwoNumbers test = new AddTwoNumbers();
        test.sum();
    }
}
