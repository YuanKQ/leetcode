#-*- coding: utf-8 -*-
"""
*****************************************
 @Time    : 2018/2/6 14:53
 @Author  : Yuan Kaiqi
 @Site    : 
 @File    : swap-nodes-in-pairs.py
 @Software: PyCharm
 @Desctiption:
  Given a linked list, swap every two adjacent nodes and return its head.

  For example,
  Given 1->2->3->4, you should return the list as 2->1->4->3.

  Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
*******************************************
"""

# Definition for singly-linked list.

import json

class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def swapPairs(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if not head:
            return head
        dummy = ListNode(0)
        dummy.next = head
        pre = dummy
        while head:
            nn = head.next
            if not nn:
                return dummy.next
            pre.next = nn
            head.next = nn.next
            nn.next = head
            pre = head
            head = head.next

        return dummy.next

def stringToIntegerList(input):
    return json.loads(input)

def stringToListNode(numbers):
    # Generate list from the input
    # numbers = stringToIntegerList(input)

    # Now convert that list into linked list
    dummyRoot = ListNode(0)
    ptr = dummyRoot
    for number in numbers:
        ptr.next = ListNode(number)
        ptr = ptr.next

    ptr = dummyRoot.next
    return ptr

def listNodeToString(node):
    if not node:
        return "[]"

    result = ""
    while node:
        result += str(node.val) + ", "
        node = node.next
    return "[" + result[:-2] + "]"

def main():
    import sys
    def readlines():
        for line in [[1,2,4], [1,3,4]]:
            yield line.strip('\n')

    # lines = readlines()
    while True:
        try:
            # line = lines.next()
            l1 = stringToListNode([1, 2, 3, 4, 5]);
            # line = lines.next()
            l2 = stringToListNode([1]);

            ret = Solution().swapPairs(l1)

            out = listNodeToString(ret);
            print(out)
        except StopIteration:
            break

if __name__ == '__main__':
    main()