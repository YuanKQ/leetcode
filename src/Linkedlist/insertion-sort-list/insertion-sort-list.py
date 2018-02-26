#-*- coding: utf-8 -*-
"""
*****************************************
 @Time    : 2018/2/9 0:39
 @Author  : Yuan Kaiqi
 @Site    : 
 @File    : insertion-sort-list.py
 @Software: PyCharm
 @Desctiption:
 Sort a linked list using insertion sort.
*******************************************
"""
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def insertionSortList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if not head:
            return head
        dummy = ListNode(0)                         #为链表加一个头节点
        dummy.next = head
        cur = head
        while cur.next:
            if cur.next.val < cur.val:  #如果链表是升序的，那么curr指针一直往后移动
                pre = dummy
                while pre.next.val <= cur.next.val:
                    pre = pre.next
                tmp = cur.next
                cur.next = tmp.next
                tmp.next = pre.next
                pre.next = tmp
            else:
                cur = cur.next
        return dummy.next

    ### Time Limit exceed
    def insertionSortList_WRONG(self, head):
        # write your code here
        dummy = ListNode(0)

        while head:
            temp = dummy
            next = head.next
            while temp.next and temp.next.val < head.val:
                temp = temp.next

            head.next = temp.next
            temp.next = head
            head = next

        return dummy.next


    ### 很投机取巧
    def insertionSortList_smart(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if head is None: return None

        arr = []
        while head is not None:
            arr.append(head.val)
            head = head.next

        res = ListNode(0)
        pt = res
        for i in sorted(arr):
            pt.next = ListNode(i)
            pt = pt.next

        return res.next