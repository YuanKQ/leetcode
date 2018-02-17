#-*- coding: utf-8 -*-
"""
*****************************************
 @Time    : 2018/2/10 23:56
 @Author  : Yuan Kaiqi
 @Site    : 
 @File    : 132-pattern.py
 @Software: PyCharm
 @Desctiption:
    Given a sequence of n integers a1, a2, ..., an, a 132 pattern is a subsequence ai, aj, ak such that i < j < k and ai < ak < aj. Design an algorithm that takes a list of n numbers as input and checks whether there is a 132 pattern in the list.

    Note: n will be less than 15,000.

    Example 1:
    Input: [1, 2, 3, 4]

    Output: False

    Explanation: There is no 132 pattern in the sequence.
    Example 2:
    Input: [3, 1, 4, 2]

    Output: True

    Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
    Example 3:
    Input: [-1, 3, 2, 0]

    Output: True

    Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].
*******************************************
"""

class Solution:
    def find132pattern(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        # length = len(nums)
        # if length < 3:
        #     return False
        # i = 0
        # while i < length - 2:
        #     j = i
        #     while nums[j] < nums[j + 1]:
        #         j += 1
        #     k = j + 1
        #     while k < length:
        #         if nums[k] > nums[i]:
        #             return True
        #         k += 1
        #     i = j + 1
        #
        # return False
        stack = []
        length = len(nums)
        if length < 3:
            return False
        third = float("-inf")
        while length:
            length -= 1
            if nums[length] < third:
                return True
            while stack and nums[length] > stack[-1]:
                third = stack.pop()
            stack.append(nums[length])

        return False

print(Solution().find132pattern([2, 3, 5, 6, 4, 5, 1, 3, 2, 0]))