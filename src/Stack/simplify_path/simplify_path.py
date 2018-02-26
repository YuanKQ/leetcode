#-*- coding: utf-8 -*-
"""
*****************************************
 @Time    : 2018/2/11 15:05
 @Author  : Yuan Kaiqi
 @Site    : 
 @File    : simplify_path.py
 @Software: PyCharm
 @Desctiption:

  Given an absolute path for a file (Unix-style), simplify it.

  For example,
  path = "/home/", => "/home"
  path = "/a/./b/../../c/", => "/c"
  click to show corner cases.

  Corner Cases:
  Did you consider the case where path = "/../"?
  In this case, you should return "/".
  Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
  In this case, you should ignore redundant slashes and return "/home/foo".
*******************************************
"""

class Solution:
    def simplifyPath(self, path):
        """
        :type path: str
        :rtype: str
        """
        stack = []
        paths = path.split("/")
        for item in paths:
            if len(item) == 0:
                continue
            if item == ".." and stack:
                stack.pop()
            elif item != ".":
                stack.append(item)
        if not stack:
            return "/"
        result = ""
        while stack:
            result += "/"
            result += (stack.pop(0))

        return result

    def simplifyPath_improve(self, path):
        stack = []
        paths = path.split("/")
        for item in paths:  # 判断条件的摆放位置
            if item == ".." and stack:
                stack.pop()
            elif item and item != ".":
                stack.append(item)

        # 使用join尽一步优化
        return "/" + "/".join(stack)
print(Solution().simplifyPath("/..."))