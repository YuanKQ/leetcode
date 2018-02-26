#-*- coding: utf-8 -*-
"""
*****************************************
 @Time    : 2018/2/11 18:27
 @Author  : Yuan Kaiqi
 @Site    : 
 @File    : binary-tree-inorder-traversal.py
 @Software: PyCharm
 @Desctiption:
  Given a binary tree, return the inorder traversal of its nodes' values.

  For example:
  Given binary tree [1,null,2,3],
     1
      \
       2
      /
     3
  return [1,3,2].

  Note: Recursive solution is trivial, could you do it iteratively?
*******************************************
"""

class Solution_recursive:
    def inorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        result = []
        if not root:
            return result
        self.helper(root, result)
        return result

    def helper(self, root, result):
        if root.left:
            self.helper(root.left, result)
        result.append(root.val)
        if root.right:
               self.helper(root.right, result)


class Solution_stack:
    def inorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        result = []
        if not root:
            return result
        self.helper(root, result)
        return result

    def helper(self, root, result):
        if root.left:
            self.helper(root.left, result)
        result.append(root.val)
        if root.right:
               self.helper(root.right, result)