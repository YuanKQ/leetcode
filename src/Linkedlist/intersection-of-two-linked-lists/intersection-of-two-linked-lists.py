#-*- coding: utf-8 -*-
"""
*****************************************
 @Time    : 2018/2/5 15:41
 @Author  : Yuan Kaiqi
 @Site    : 
 @File    : intersection-of-two-linked-lists.py
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
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

import math

def getLinkedListLength(head):
        length = 0
        ptr = head
        while ptr != None:
            length += 1
            ptr = ptr.next
        return length

class Solution:
    """
    @param: headA: the first list
    @param: headB: the second list
    @return: a ListNode
    """
    def getIntersectionNode(self, headA, headB):
        # write your code here
        lenA = getLinkedListLength(headA)
        lenB = getLinkedListLength(headB)
        ptrA = headA
        ptrB = headB
        if lenA > lenB:
            ahead = lenA -lenB
            i = 0
            while i < ahead:
                ptrA = ptrA.next
                i += 1
        else:
            ahead = lenB - lenA
            i = 0
            while i < ahead:
                ptrB = ptrB.next
                i += 1
        while ptrA != None and ptrB != None:
            if ptrA == ptrB:
                return ptrA
            ptrA = ptrA.next
            ptrB = ptrB.next
        return None