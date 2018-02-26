#-*- coding: utf-8 -*-
"""
*****************************************
 @Time    : 2018/2/7 22:00
 @Author  : Yuan Kaiqi
 @Site    : 
 @File    : partition-list.py
 @Software: PyCharm
 @Desctiption:
  Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

  You should preserve the original relative order of the nodes in each of the two partitions.

  For example,
  Given 1->4->3->2->5->2 and x = 3,
  return 1->2->2->4->3->5.
*******************************************
"""

# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
     def partition(self, head, x):
        """
        :type head: ListNode
        :type x: int
        :rtype: ListNode
        """
        if not head or not head.next:
            return head
        ptr = head
        flag = False
        minhead = minp = None
        maxhead = maxp = None
        resthead = rest = None
        while ptr:
            next = ptr.next
            if ptr.val == x:
                flag = True
                resthead = ptr
                rest = ptr
            elif ptr.val < x:
                if not minhead:
                    minhead = ptr
                    minp = ptr
                else:
                    minp.next = ptr
                    minp = minp.next
            elif not flag:
                if not maxhead:
                    maxhead = ptr
                    maxp = maxhead
                else:
                    maxp.next = ptr
                    maxp = maxp.next
            else:
                rest.next = ptr
                rest = rest.next
            ptr = next

        minhead.next = maxhead
        maxhead.next = resthead
        rest.next = None
        return minhead


     def partition_better(self, head, n):
         if not head or not head.next:
            return head

         small = s_dummy = ListNode(-1)
         large = l_dummy = ListNode(-1)

         while head:
             if head.val < x:
                 small.next = head
                 small = small.next
             else:
                 large.next = head
                 large = large.next
             head = head.next

         large.next = None
         small.next = l_dummy.next

         return s_dummy.next


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
    head = stringToListNode([4,5,2,1,3,2,4])
    n = 3

    ret = Solution().partition(head, n)

    out = listNodeToString(ret)
    print(out)

if __name__ == '__main__':
    main()