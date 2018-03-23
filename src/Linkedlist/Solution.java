/******************************
 * User: yuan
 * Date: 18-3-19 下午9:17
 * Email: kq_yuan@outlook.com
 *
 * Description:
 *
 ******************************/
package Linkedlist;


import java.util.concurrent.ConcurrentHashMap;

public class Solution {
    public ListNode FindKthToTail(ListNode head, int k) {
        ListNode fast = head;
        while (k > 0) {
            k --;
            fast = fast.next;
        }
        ListNode slow = head;
        while (fast != null){
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        new Solution().FindKthToTail(node1, 5);
//        ConcurrentHashMap
    }
}