#-*- coding: utf-8 -*-
"""
*****************************************
 @Time    : 2018/2/8 14:48
 @Author  : Yuan Kaiqi
 @Site    : 
 @File    : linked-list-cycle-ii.py
 @Software: PyCharm
 @Desctiption:

 Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

 Note: Do not modify the linked list.

 Follow up:
 Can you solve it without using extra space?
*******************************************
"""

def detectCycle(head):
    """
    :type head: ListNode
    :rtype: ListNode
    """
    if not head or not head.next:
        return head
    p1 = head.next.next
    p2 = head.next
    while p2 and p2.next:
        if p1 == p2:
            p2 = head
            break;
        p2 = p2.next.next
        p1 = p1.next
    if not p2 or not p2.next:
        return None
    while p2 != p1:
        p2 = p2.next
        p1 = p1.next
    return p2

head = ListNode(1)
ptr = head
for i in range(2, 3):
    ptr.next = ListNode(i)
    ptr = ptr.next
#     if i == 3:
#         temp = ptr
# ptr.next = temp

# head = ListNode(0)
# ptr = head
# for i in range(3):
#     ptr.next = ListNode(i)
#     ptr = ptr.next
# head = head.next

detectCycle(head)

def detectCycle(head):
    """
    :type head: ListNode
    :rtype: ListNode
    """
    if not head or not head.next:
        return head
    p1 = head.next.next
    p2 = head.next
    while p2 and p2.next:
        if p1 == p2:
            p2 = head
            break;
        p2 = p2.next.next
        p1 = p1.next
    if not p2 or not p2.next:
        return None
    while p2 != p1:
        p2 = p2.next
        p1 = p1.next
    return p2

head = ListNode(1)
ptr = head
for i in range(2, 3):
    ptr.next = ListNode(i)
    ptr = ptr.next
#     if i == 3:
#         temp = ptr
# ptr.next = temp

# head = ListNode(0)
# ptr = head
# for i in range(3):
#     ptr.next = ListNode(i)
#     ptr = ptr.next
# head = head.next

detectCycle(head)
