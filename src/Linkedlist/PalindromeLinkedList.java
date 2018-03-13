/******************************
 * User: yuan
 * Date: 18-3-12 下午9:15
 * Email: kq_yuan@outlook.com
 *
 * Description:
 *
 ******************************/
package Linkedlist;

import java.util.Stack;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        if (head.next.val == head.val && head.next.next == null)
            return true;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode pre = null;
        while (slow.next != null) {
            ListNode tmp = slow.next;
            slow.next = pre;
            pre = slow;
            slow = tmp;
        }
        slow.next = pre;

        pre = head;
        while (pre != null) {
            if (pre.val != slow.val)
                return false;
            pre = pre.next;
            slow = slow.next;

        }

        return true;

//        if (head == null || head.next == null)
//            return true;
//        int count = 0;
//        ListNode cur = head;
//        while (cur != null) {
//            cur = cur.next;
//            count ++;
//        }
//        boolean odd = count % 2 == 1? true: false;
//        int mid = count / 2;
//        ListNode mNode = head;
//        while (mid > 0) {
//            mNode = mNode.next;
//            mid --;
//        }
//
//        if (odd) {
//            mNode.val = mNode.next.val;
//            mNode.next = mNode.next.next;
//        }
//
//        Stack<Integer> stack = new Stack<Integer>();
//        stack.push(head.val);
//        cur = head.next;
//        while (cur != null) {
//            if (stack.empty() && stack.peek() == cur.val)
//                stack.pop();
//            else
//                stack.push(cur.val);
//            cur = cur.next;
//        }
//
//        return stack.empty();
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;


        System.out.println(new PalindromeLinkedList().isPalindrome(node1));
    }
}
