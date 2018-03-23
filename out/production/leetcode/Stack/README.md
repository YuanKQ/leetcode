## 重点题目
*建议重刷*
- min_stack
- 132-pattern
- binary-tree-traversal
- convert-sorted-list-to-binary-search-tree

## 题目详解
### min_stack
- “双栈法”能否进一步优化？

### 132-pattern
- 遍历法其实还是可以进一步优化的

### simplify_path
- 条件的摆放位置很重要

### convert-sorted-list-to-binary-search-tree
- 充分利用数据结构本身的特性：
  > sorted-list: 具有排列顺序
  >
  > binary-search-tree: 二分查找，遍历方式
- 对于tree而言，左右节点均为None的节点即为叶子节点

## 总结
- 要从“栈”或“队列”的角度考虑问题
- ```"/".join(["1", "2", "3"])```结果为```1/2/3```，第一个元素之前没有分隔符
- 使用“栈”或“队列”的数据的顺序往往跟取出顺序一致 ==》 evaluate-reverse-polish-notation
