#-*- coding: utf-8 -*-
"""
*****************************************
 @Time    : 2018/2/4 13:51
 @Author  : Yuan Kaiqi
 @Site    : 
 @File    : best_result.py
 @Software: PyCharm
 @Desctiption:

            ┏┛┻━━━┛┻┓
            ┃             ┃
            ┃  ┳┛  ┗┳  ┃
            ┃      ┻      ┃
            ┗━┓      ┏━┛
                ┃      ┗━━━┓
                ┃   N  O     ┣┓
                ┃　 B U G！   ┏┛
                ┗┓┓┏━┳┓┏┛
                  ┃┫┫  ┃┫┫
                  ┗┻┛  ┗┻┛
*******************************************
"""
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

        if l1.val < l2.val:
            l1.next = self.mergeTwoLists(l1.next, l2)
            return l1
        else:
            l2.next = self.mergeTwoLists(l1, l2.next)
            return l2

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