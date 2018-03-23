#-*- coding: utf-8 -*-
"""
*****************************************
 @Time    : 2018/2/9 1:50
 @Author  : Yuan Kaiqi
 @Site    : 
 @File    : valid-parentheses.py
 @Software: PyCharm
 @Desctiption:
  Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

  The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*******************************************
"""
class Solution:
    def equals(self, l, r):
        if l == "(":
            return r == ")"
        if l == "[":
            return r == "]"
        if l == "{":
            return r == "}"

    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        if len(s) % 2 == 1:
            return False
        l = []
        for i in s:
            l.append(i)
        r = []
        r.append(l.pop())
        while len(l) > 0:
            if len(r) > 0:
                while len(r) > 0 and self.equals(l[-1], r[-1]):
                    l.pop()
                    r.pop()
                if len(l) > 0 and l[-1] in ["{", "(", "["]:
                    return False
            if len(l) > 0:
                r.append(l.pop())
        if len(r):
            return False
        return True

print(Solution().isValid("[][]()"))