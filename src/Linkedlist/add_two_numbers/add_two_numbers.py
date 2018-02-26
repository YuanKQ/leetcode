#-*- coding: utf-8 -*-
"""
*****************************************
 @Time    : 2018/2/6 11:32
 @Author  : Yuan Kaiqi
 @Site    : 
 @File    : add_two_numbers.py
 @Software: PyCharm
 @Desctiption:
 You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

 You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 Example

    Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
    Output: 7 -> 0 -> 8
    Explanation: 342 + 465 = 807.
*******************************************
"""

# Definition for singly-linked list.

import json

class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
     def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype l3: ListNode
        """
        if not l1 or not l2:
            return l2 or l1
        carry = 0
        head = ListNode(-1)
        l3 = head
        while l1 != None and l2 != None:
            tmp = l1.val + l2.val + carry
            if tmp >= 10:
                carry = tmp / 10
                tmp -= 10
            else:
                carry = 0
            l3.next = ListNode(tmp)
            l3 = l3.next
            l1 = l1.next
            l2 = l2.next
        while l1 != None:
            tmp = l1.val + carry
            if tmp >= 10:
                carry = tmp / 10
                tmp -= 10
            else:
                carry = 0
            l3.next = ListNode(tmp)
            l3 = l3.next
        while l2 != None:
            tmp = l2.val + carry
            if tmp >= 10:
                carry = tmp / 10
                tmp -= 10
            else:
                carry = 0
            l3.next = ListNode(tmp)
            l3 = l3.next
        if carry > 0:
            l3.next = ListNode(carry)
        return head.next

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
            l1 = stringToListNode([1,8]);
            # line = lines.next()
            l2 = stringToListNode([1]);

            ret = Solution().addTwoNumbers(l1, l2)

            out = listNodeToString(ret);
            print(out)
        except StopIteration:
            break

if __name__ == '__main__':
    main()