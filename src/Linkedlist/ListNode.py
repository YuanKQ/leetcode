#-*- coding: utf-8 -*-
"""
*****************************************
 @Time    : 2018/2/5 14:20
 @Author  : Yuan Kaiqi
 @Site    : 
 @File    : ListNode.py
 @Software: PyCharm
 @Desctiption:

            ┏┛┻━━━┛┻┓
            ┃             ┃
            ┃  ┳┛  ┗┳  ┃
            ┃      ┻      ┃
            ┗━┓      ┏━┛
                ┃      ┗━━━┓
                ┃   N  O     ┣┓
                ┃　 B U G！   ┏┛
                ┗┓┓┏━┳┓┏┛
                  ┃┫┫  ┃┫┫
                  ┗┻┛  ┗┻┛
*******************************************
"""


# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None