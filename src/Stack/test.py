#-*- coding: utf-8 -*-
"""
*****************************************
 @Time    : 2018/2/12 22:34
 @Author  : Yuan Kaiqi
 @Site    : 
 @File    : test.py
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
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def sortList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if not head:
            return
        node = head
        ary = []
        while node:
            ary.append(node.val)
            node = node.next
        ary = self.quick_sort(ary)
        dummy = ListNode(-1)
        node = dummy
        for i in ary:
            node.next = ListNode(i)
            node = node.next
        return dummy.next

    def quick_sort(self, ary):
        if not ary:
            return []
        equals = []
        smalls = []
        larges = []
        value = ary.pop()
        for i in ary:
            if i == value:
                equals.append(i)
            elif i < value:
                smalls.append(i)
            else:
                larges.append(i)
        return self.quick_sort(smalls) + equals + self.quick_sort(larges)

import random
dummy = ListNode(-1)
node = dummy
for i in range(1):
    value = random.randint(1, 20)
    node.next = ListNode(value)
    node = node.next

Solution().sortList(dummy.next)