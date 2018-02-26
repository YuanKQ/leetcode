#-*- coding: utf-8 -*-
"""
*****************************************
 @Time    : 2018/2/17 21:15
 @Author  : Yuan Kaiqi
 @Site    : 
 @File    : convert-sorted-list-to-binary-search-tree.py
 @Software: PyCharm
 @Desctiption:

  Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

  For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.


  Example:

  Given the sorted linked list: [-10,-3,0,5,9],

  One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

        0
       / \
     -3   9
     /   /
   -10  5
*******************************************
"""
import math

# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def sortedListToBST(self, head):
        """
        :type head: ListNode
        :rtype: TreeNode
        """
        if not head:
            return None
        values = []
        while head:
            values.append(head.val)
            head = head.next
        return self.build_tree(values, 0, len(values)-1)


    def build_tree(self, values, left, right):
        if left == right:
            return TreeNode(values[left])
        mid = math.ceil((left + right) / 2)
        ancestor = TreeNode(values[mid])
        if left <= mid-1:
            ancestor.left = self.build_tree(values, left, mid-1)
        if mid + 1 <= right:
            ancestor.right = self.build_tree(values, mid+1, right)
        return ancestor


class Solution_better:
    def sortedListToBST(self, head):
        """
        :type head: ListNode
        :rtype: TreeNode
        """
        if head is None:
            return None

        node, length = head, 0

        while node:
            node = node.next
            length += 1

        self.curr = head

        return self.inorder(0, length - 1)

    def inorder(self, start, end):
        if start > end:
            return None

        mid = (start + end) // 2
        left = self.inorder(start, mid - 1)

        root = TreeNode(self.curr.val)
        root.left = left

        self.curr = self.curr.next

        root.right = self.inorder(mid + 1, end)

        return root


l = [-10, -3, 0, 5, 9]
dummy = ListNode(float("-inf"))
head = dummy
for i in l:
    head.next = ListNode(i)
    head = head.next

Solution().sortedListToBST(dummy.next)