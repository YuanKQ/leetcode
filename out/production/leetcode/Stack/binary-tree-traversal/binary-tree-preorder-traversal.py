#-*- coding: utf-8 -*-
"""
*****************************************
 @Time    : 2018/2/12 21:59
 @Author  : Yuan Kaiqi
 @Site    : 
 @File    : binary-tree-preorder-traversal.py
 @Software: PyCharm
 @Desctiption:

 Given a binary tree, return the preorder traversal of its nodes' values.

 For example:
 Given binary tree [1,null,2,3],
    1
     \
      2
     /
    3
 return [1,2,3].

 Note: Recursive solution is trivial, could you do it iteratively?
*******************************************
"""
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution_recursive:
    def preorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if not root:
            return []
        result = []
        self.preorderTree(root, result)
        return result

    def preorderTree(self, root, result):
        result.append(root.val)
        if root.left:
            self.preorderTree(root.left, result)
        if root.right:
            self.preorderTree(root.right, result)

class Solution_iteratively:
    def preorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if not root:
            return []
        result = []
        stack = []
        node = root
        stack.append(node)
        while stack:
            node = stack.pop()
            result.append(node.val)
            if node.right:
                stack.append(node.right)
            if node.left:
                stack.append(node.left)
        return result