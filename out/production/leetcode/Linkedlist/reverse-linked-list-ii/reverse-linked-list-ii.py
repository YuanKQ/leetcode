#-*- coding: utf-8 -*-
"""
*****************************************
 @Time    : 2018/2/7 23:42
 @Author  : Yuan Kaiqi
 @Site    : 
 @File    : reverse-linked-list-ii.py
 @Software: PyCharm
 @Desctiption:
  Reverse a linked list from position m to n. Do it in-place and in one-pass.

  For example:
  Given 1->2->3->4->5->NULL, m = 2 and n = 4,

  return 1->4->3->2->5->NULL.

  Note:
  Given m, n satisfy the following condition:
  1 ≤ m ≤ n ≤ length of list.
*******************************************
"""
# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def reverseBetween(self, head, m, n):
        """
        :type head: ListNode
        :type m: int
        :type n: int
        :rtype: ListNode
        """
        if m == n or not head:
            return head
        dummy = ListNode(-1)
        dummy.next = head
        cur = dummy
        for i in range(1, m):
            cur = cur.next
        phead = cur
        pre = None
        cur = cur.next
        ptail = cur
        for i in range(m, n+1):
            nextp = cur.next
            cur.next = pre
            pre = cur
            cur = nextp
        phead.next = pre
        ptail.next = cur
        return dummy.next

    def reverseBetweenBetter(self, head, m, n):
        if m == n or not head:
            return head
        dummy = ListNode(-1)
        dummy.next = head
        cur = dummy
        for i in range(1, m):
            cur = cur.next

        tail = cur.next
        while i in range(m, n):
            tmp = tail.next
            tail.next = tmp.next
            tmp.next = cur.next
            cur.next = tmp

        return dummy.next


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
    head = stringToListNode([1,2,3,4,5,6,7,8])
    m = 3
    n = 6

    ret = Solution().reverseBetween(head, m, n)

    out = listNodeToString(ret)
    print(out)

if __name__ == '__main__':
    main()

