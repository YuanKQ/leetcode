#-*- coding: utf-8 -*-
"""
*****************************************
 @Time    : 2018/2/10 22:01
 @Author  : Yuan Kaiqi
 @Site    : 
 @File    : min_stack.py
 @Software: PyCharm
 @Desctiption:

  Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

  push(x) -- Push element x onto stack.
  pop() -- Removes the element on top of the stack.
  top() -- Get the top element.
  getMin() -- Retrieve the minimum element in the stack.
  Example:
  MinStack minStack = new MinStack();
  minStack.push(-2);
  minStack.push(0);
  minStack.push(-3);
  minStack.getMin();   --> Returns -3.
  minStack.pop();
  minStack.top();      --> Returns 0.
  minStack.getMin();   --> Returns -2.
*******************************************
"""

class MinStack:

    def __init__(self):
        # do intialization if necessary
        self.stack = []
        self.minimum = float("inf")
        self.orderlist = []

    """
    @param: number: An integer
    @return: nothing
    """
    def push(self, number):
        # write your code here
        self.stack.append(number)
        if number < self.minimum:
            self.minimum = number
        self.orderlist.append(self.minimum)
    """
    @return: An integer
    """
    def pop(self):
        # write your code here
        result = self.stack.pop()
        self.orderlist.pop()
        if len(self.stack) == 0:
            self.minimum = float("inf")
        else:
            self.minimum = self.orderlist[-1]
        return result
    """
    @return: An integer
    """
    def min(self):
        # write your code here
        if len(self.stack) < 0:
            return
        else:
            return self.orderlist[-1]


class MinStack_improve:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        self.orderlist = []

    def push(self, number):
        """
        :type x: int
        :rtype: void
        """
        self.stack.append(number)
        if not self.orderlist or self.orderlist[-1] >= number:
            self.orderlist.append(number)

    def pop(self):
        """
        :rtype: void
        """
        if self.orderlist and self.stack[-1] == self.orderlist[-1]:
            self.orderlist.pop()

        return self.stack.pop()

    def top(self):
        """
        :rtype: int
        """
        return self.stack[-1]

    def getMin(self):
        """
        :rtype: int
        """
        if self.orderlist:
            return self.orderlist[-1]
        else:
            return



m = MinStack()
m.push(1)
m.pop()
m.push(2)
m.push(3)
m.min()
m.push(1)
m.min()