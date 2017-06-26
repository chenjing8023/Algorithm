package Leetcode;

import java.util.Stack;

/**
 * Created by hadoop on 17-5-28.
 */
public class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> stack1 = new Stack<ListNode>();
        Stack<ListNode> stack2 = new Stack<ListNode>();
        Stack<Integer> result = new Stack<Integer>();
        while (l1 !=null){
            stack1.push(l1);
            l1=l1.next;
        }
        while (l2 !=null){
            stack2.push(l2);
            l2=l2.next;
        }
        int res = 0;
        int sum = 0;
        while (!stack1.isEmpty() && !stack2.isEmpty()){
            sum = stack1.pop().val + stack2.pop().val + res;
            res = sum/10;
            sum = sum%10;
            result.push(sum);
        }
        while ( !stack1.isEmpty()){
            sum = res + stack1.pop().val;
            res = sum / 10;
            sum = sum%10;
            result.push(sum);
        }
        while ( !stack2.isEmpty()){
            sum = res + stack2.pop().val;
            res = sum / 10;
            sum = sum%10;
            result.push(sum);
        }
        if(res != 0)
            result.push(1);
        ListNode head=new ListNode(result.pop());
        ListNode tmp=head;
        while(!result.empty()){
            ListNode node=new ListNode(result.pop());
            tmp.next=node;
            tmp=tmp.next;
        }
        return head;
    }
    public ListNode reverse(ListNode head){
        if(head == null)
            return null;
        ListNode current = head;
        ListNode next = null;
        ListNode prev = null;
        while (current != null){
            //current = prev.next;
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
