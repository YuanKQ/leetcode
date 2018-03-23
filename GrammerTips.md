# 常见数据结构
## Stack
- *boolean* empty() 

测试堆栈是否为空。
- *Object* peek( )

查看堆栈顶部的对象，但不从堆栈中移除它。
- *Object* pop( )

移除堆栈顶部的对象，并作为此函数的值返回该对象。
- *Object* push(Object element)

把项压入堆栈顶部。
- *int* search(Object element)

返回对象在堆栈中的位置，以 1 为基数。
- *boolean* empty()

倘若stack为空，返回true，否则返回false
## Queue
- *boolean* add(E e)
向队列中插入元素
- *boolean* offer(E e)
向队列中插入元素
- *E* element()
返回队列中第一个元素
- *E* peek()
返回队列第一个元素
- *E* poll()
取出队列第一个元素
- *E* remove()
取出队列第一个元素
## String
- *char* charAt(int index)
访问第index个字符


# 常见类型转化
## String转Char Array
```
String str = "hello";
char[] chars = str.toCharArray();

``` 
## String转int
```
String str = "123";
int i = Integer.parseInt(str);
int j = Integer.valueOf(str);
```

## char转String
```
char c = 'c';
String s = String.valueOf(c);
```
## int转String
```
int k = 1;
String s = "" + k;
String ss = Integer.toString(k); // 尽量不要用，贼慢。
```

## ArrayList转Array
```
List<Integer> iList = new ArrayList<>();
iList.add(0);
iList.add(1);
iList.add(2);
iList.add(3);
int[] iarray = iList.toArray(new Integer[iList.size()]);  // new int[iList.size()]会报错
```
## 各种类型Array转String
- *String*  Arrays.toString(boolean [] a)
- *String*  Arrays.toString(byte[] a)
- *String*  Arrays.toString(char[] a)
- *String*  Arrays.toString(double[] a)
- *String*  Arrays.toString(float[] a)
- *String*  Arrays.toString(int[] a)
- *String*  Arrays.toString(long[] a)
- *String*  Arrays.toString(Object[] a)
- *String*  Arrays.toString(short[] a)
- *String*  Arrays.toString([] a)
- *String*  Arrays.toString([] a)