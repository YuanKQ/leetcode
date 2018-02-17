#-*- coding: utf-8 -*-
"""
*****************************************
 @Time    : 2018/2/6 14:19
 @Author  : Yuan Kaiqi
 @Site    : 
 @File    : remove-nth-node-from-end-of-list.py
 @Software: PyCharm
 @Desctiption:
 Given a linked list, remove the nth node from the end of list and return its head.

 For example,

    Given linked list: 1->2->3->4->5, and n = 2.

    After removing the second node from the end, the linked list becomes 1->2->3->5.
 Note:
    Given n will always be valid.
    Try to do this in one pass.
*******************************************
"""
# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
     def removeNthFromEnd(self, head, n):
        """
        :type head: ListNode
        :type n: int
        :rtype: ListNode
        """
        if not head:
            return None
        ptr = head
        while n:
            n -= 1
            ptr = ptr.next
        ptr1 = head
        # 处理头节点
        if not ptr:
            head = head.next
            return head
        while ptr.next:
            ptr = ptr.next
            ptr1 = ptr1.next
        ptr1.next = ptr1.next.next

        return head


def stringToListNode(numbers):
    # Generate list from the input
    # numbers = json.loads(input)

    # Now convert that list into linked list
    dummyRoot = ListNode(0)
    ptr = dummyRoot
    for number in numbers:
        ptr.next = ListNode(number)
        ptr = ptr.next

    ptr = dummyRoot.next
    return ptr

def stringToInt(input):
    return int(input)

def listNodeToString(node):
    if not node:
        return "[]"

    result = ""
    while node:
        result += str(node.val) + ", "
        node = node.next
    return "[" + result[:-2] + "]"

def main():
    head = stringToListNode([4,5,2,1,3,2,4])
    n = 3

    ret = Solution().removeNthFromEnd(head, n)

    out = listNodeToString(ret)
    print(out)

if __name__ == '__main__':
    main()