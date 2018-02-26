#-*- coding: utf-8 -*-
"""
*****************************************
 @Time    : 2018/2/8 15:20
 @Author  : Yuan Kaiqi
 @Site    : 
 @File    : reorder_list.py
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

# Definition for singly-linked list.
import math


class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
     def reorderList(self, head):
        """
        :type head: ListNode
        :rtype: void Do not return anything, modify head in-place instead.
        """
        fast = head
        length = 0
        myMap = {}
        myMap[length] = fast
        while fast:
            length += 1
            fast = fast.next
            myMap[length] = fast
        if length <= 2:
            return
        step = int(length/2)
        for i in range(step):
            last_index = length - i -1
            myMap[last_index - 1].next = myMap[last_index].next
            myMap[last_index].next = myMap[i].next
            myMap[i].next = myMap[last_index]

        return


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
    head = stringToListNode([1,2,3,4])
    n = 3

    ret = Solution().reorderList(head)

    out = listNodeToString(ret)
    print(out)

if __name__ == '__main__':
    main()