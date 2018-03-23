#-*- coding: utf-8 -*-
"""
*****************************************
 @Time    : 2018/2/4 12:10
 @Author  : Yuan Kaiqi
 @Site    : 
 @File    : merge_two_sorted_list.py
 @Software: PyCharm
 @Desctiption:
    Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

    Example:

    Input: 1->2->4, 1->3->4
    Output: 1->1->2->3->4->4
*******************************************
"""

# Definition for singly-linked list.

import json

class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def mergeTwoLists(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype l3: ListNode
        """
        if not l1 or not l2:
            return l1 or l2

        l3 = ListNode(0)
        head = l3
        while l1 != None and l2 != None:
            if l1.val <= l2.val:
                l3.next = l1
                l1 = l1.next
            else:
                l3.next = l2
                l2 = l2.next
            l3 = l3.next
        if l1 != None:
            l3.next = l1
        else:
            l3.next = l2
        l3 = head.next
        return l3

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
            l1 = stringToListNode([2]);
            # line = lines.next()
            l2 = stringToListNode([1]);

            ret = Solution().mergeTwoLists(l1, l2)

            out = listNodeToString(ret);
            print(out)
        except StopIteration:
            break

if __name__ == '__main__':
    main()