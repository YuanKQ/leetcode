#-*- coding: utf-8 -*-
"""
*****************************************
 @Time    : 2018/2/8 1:41
 @Author  : Yuan Kaiqi
 @Site    : 
 @File    : copy-list-with-random-pointer.py
 @Software: PyCharm
 @Desctiption:
  A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

  Return a deep copy of the list.
*******************************************
"""

# Definition for singly-linked list with a random pointer.
class RandomListNode(object):
    def __init__(self, x):
        self.label = x
        self.next = None
        self.random = None

class Solution(object):
    def copyRandomList(self, head):
        """
        :type head: RandomListNode
        :rtype: RandomListNode
        """
        if not head:
            return head
        nhead = RandomListNode(-1)
        p = head
        np = nhead
        addressMap = {}
        while p:
            np.next = RandomListNode(p.label)
            addressMap[p] = np.next
            np = np.next
            p = p.next
        np = nhead.next
        p = head
        while np:
            if p.random:
                np.random = addressMap[p.random]
            p = p.next
            np = np.next

        return nhead.next