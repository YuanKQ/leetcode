Some solutions to Linkedlist and Stack&Queue are written in Python, the rest are written in Java.

## 奇技淫巧
- 结果的顺序也有可能导致`wrong answer`. 参见`./JobHuner/StringPermuation.java`
## 奇思妙想
- 与2相关的运算可以考虑位运算(N = 2^n, 正数负数都是同样的运算)
  - 除法，op >> logN
  - 乘法，op << logN
  - 取余，op ^(op-1)
  
- 倘若面试题是按照一定要求摆放若干数字，可以先求出这些数字的所有排列，然后再一一判断每个排列是否满足题目给定的要求。

- 如果需要判断多个字符是不是在某个字符里出现过或者统计多个字符中出现的次数，可以考虑`HashMap`.

- 树的问题归根结底是遍历顺序的问题（前序，中序，后序）

- 链表的问题归根结底是指针问题
  - 单指针
  - 双指针（一快一慢，以前一后）
  
- 二叉搜索树插入新数据的平均时间为 `O(logn)`

- 可以PriorityQueue实现大根堆小根堆
