## 重点题目
*建议重刷*
- reverse-linked-list-ii
- linked_list_cycle, linked_list_cycle_ii
- copy_list_with-random-pointer
- insertion-sort-list

### merge two sorted list：
- 先处理边界问题，极端情况有利于提高runtime
  ```Python
  def func(l1,l2):
      if not l1 or not l2:
          return l1 or l2
      # 常规情况处理
  ```
### linked list cycle:
- 链表问题归根结底是遍历问题:

  判断一个链表中是否存在环，两个指针以不同的步数遍历，终将相遇

### swap-nodes-in-pairs:
- 改变指针的指向之前，必须先保留原来指针的内容
  ```Python
    dummy = ListNode(0)
    dummy.next = head
    pre = dummy
    while head:
        nn = head.next
        ...
        pre.next = nn
        # 先保留nn.next的值在head.next中，在重新修改nn.next的值
        head.next = nn.next
        nn.next = head
        pre = head
        head = head.next
  ```
### patition-list:
- 为避免头节点问题，可以先预设一个头节点。可以对比patition-list.py中的```partition()```与```partition_better()```

###
- 链表反转
  ```Python
  nextp = cur.next
  cur.next = pre
  pre = cur
  cur = nextp
  ```

### copy_list_with-random-pointer
- 当大量数据需要查询时，使用hashmap保留数据

### reorder-list
- leetcode 错误：“"Do not return anything, modify nums in-place instead.”

  取消返回值即可

### insertsion sort list
- 遍历顺序很重要
- 善用数据结构和常见的内部提供的函数

### 其他一些Tips：
- 循环里最后记得将指针指向下一个节点
- 获取链表的下一个节点时，必须保证当前节点为非空