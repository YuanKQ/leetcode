/******************************
 * User: yuan
 * Date: 18-3-12 下午8:24
 * Email: kq_yuan@outlook.com
 *
 * Description: [LeetCode #237]
   Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
   Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, the linked list should become 1 -> 2 -> 4 after calling your function.
 ******************************/
package Linkedlist;

public class DeleteNodeInALinkedList {
    static public void deleteNode(ListNode node) {
        // 覆盖！！！

        if (node.next != null) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
        else
            node = null;
    }
    public static void main(String[] args) {
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(1);
//        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = null;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = null;

        deleteNode(node1);
    }

}
