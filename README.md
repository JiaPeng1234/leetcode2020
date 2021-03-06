# leetcode2020
leetcode 2020 guide by huahua

## Catelog
```
    ├─BFS
    │  ├─127. Word Ladder
    │  ├─542. 01 Matrix
    │  ├─752. Open the Lock
    │  ├─934. Shortest Bridge
    │  └─994. Rotting Oranges
    ├─Binary Search
    ├─Binary Search Tree
    ├─DFS
    │  ├─131. Palindrome Partitioning
    │  ├─17. Letter Combinations of a Phone Number
    │  ├─22. Generate Parentheses
    │  ├─39. Combination Sum
    │  ├─40. Combination Sum II
    │  ├─46. Permutation
    │  ├─47. Permutations II
    │  ├─698. Partition to K Equal Sum Subsets
    │  ├─77. Combinations
    │  ├─78. Subsets
    │  ├─784. Letter Case Permutation
    │  ├─79. Word Search
    │  ├─842. Split Array into Fibonacci Sequence
    │  ├─90. Subsets II
    │  └─93. Restore IP Addresses
    ├─Dynamic Programming
    │  └─241. Different Ways to Add Parentheses
    ├─Graph
    ├─List
    ├─Tree
    ├─基本框架
    └─旧表
        └─pics

```

## Learning path
BY Jiapeng
- Leetcode path
DFS/BFS -> sort(being able to write all kinds of sorting examples) -> Binary Search -> Bit Manipulation -> basic BST -> 后面的顺序待定 -> graph, dp, basic object-oriented design,  Heap, Priority Queue, linked list -> 再下一层，后面的顺序待定 -> Balanced search trees(including AVL, Splay trees, red-black tree etc.), Binary Heap etc. -> 再下一层 -> 数据库，多线程 -> 再下一层 -> 系统设计。。。。 -> Later .....  

- Gain efficiency by checking fundamentals before writing codes:  
2 cores:  
https://github.com/jwasham/coding-interview-university/blob/master/translations/README-cn.md#%E6%97%A5%E5%B8%B8%E8%AE%A1%E5%88%92  
"Cracking the code interview"(uploaded in books catelog)  

- Also check solutions here: HuaHua  https://www.youtube.com/watch?v=Ol1e4TOHvno&list=PLLuMmzMTgVK5Hy1qcWYZcd7wVQQ1v0AjX

## Code Style Guide
### Python
- 二元操作符两边都加上一个空格, 比如赋值(=), 比较(==, <, >, !=, <>, <=, >=, in, not in, is, is not), 布尔(and, or, not).  

  ```python
  Yes: x == 1
  ```
  ```python
  No:  x<1
  ```
  例外：当’=’用于指示关键字参数或默认参数值时, 不要在其两侧使用空格.  
  
  ```python
  Yes: def complex(real, imag=0.0): return magic(r=real, i=imag)
  ```
  ```python
  No:  def complex(real, imag = 0.0): return magic(r = real, i = imag)
  ```
- 如果语句中有不同优先级的运算符，请在最低级运算符符周围添加一个空格（例如有乘除加减，加减就是最低级运算符）  
- 如果语句中有不同优先级的运算符，优先运算的运算符不用添加空格  

  ```python
  Yes: x = 1 + 2
  ```
  ```python
  No:  x = a/3
  ```

  ```python
  YES:
  i = i + 1
  submitted += 1
  x = x*2 - 1
  hypot2 = x*x + y*y
  c = (a+b) * (a-b)
  ```
  ```python
  NO:
  i=i+1
  submitted +=1
  x = x * 2 - 1
  hypot2 = x * x + y * y
  c = (a + b) * (a - b)
  ```
- 条件句中、函数参数中的运算符加不加空格也应该符合上述两原则：  
- 对于数组中的算术运算符，方便起见，暂时不需在两边加空格：  

  ```python
  Yes: if x = 1 + 2:
  ```
  ```python
  No:  if x = a/3:
  ```
  
  ```python
  Yes:  self.dfs(s, count + 1, ans, cur + s[i:i+2] + '.', i + 2)
  ```
  ```python
  No:   self.dfs(s, count + 1, ans, cur + s[i:i + 2] + '.', i + 2)
  ```
  ```python
  No:   self.dfs(s, count+1, ans, cur+s[i:i+2]+'.', i+2)
  ```
- 不要在逗号, 分号, 冒号前面加空格, 但应该在它们后面加(除了在行尾).  

  ```python
  Yes: if x == 4:
           print x, y
       x, y = y, x
  ```
  ```python
  No:  if x == 4 :
           print x , y
       x , y = y , x
  ```
- Python代码块注释和行注释.  
对于复杂的操作, 应该在其操作开始前写上若干行注释. 对于不是一目了然的代码, 应在其行尾添加注释.  
为了提高可读性, 注释应该至少离开代码1个tab的距离

  ```python
  # We use a weighted dictionary search to find out where i is in
  # the array.  We extrapolate position based on the largest num
  # in the array and the array size and then do binary search to
  # get the exact number.

  if i & (i-1) == 0:  # True if i is 0 or a power of 2.
  ```
- Python方法的注释. 在方法定义下有一个用于描述该方法的文档字符串. 其次如下:  
  Args:  
  &nbsp;&nbsp;列出每个参数的名字  
  Returns:(或者 Yields: 用于生成器)  
  &nbsp;&nbsp;描述返回值的类型和语义. 如果函数返回None, 这一部分可以省略.  
  Raises:  
  &nbsp;&nbsp;列出与接口有关的所有异常.
  
  ```python
  def fetch_bigtable_rows(big_table, keys, other_silly_variable=None):
    """Fetches rows from a Bigtable.

    Retrieves rows pertaining to the given keys from the Table instance
    represented by big_table.  Silly things may happen if
    other_silly_variable is not None.

    Args:
        big_table: An open Bigtable Table instance.
        keys: A sequence of strings representing the key of each table row
            to fetch.
        other_silly_variable: Another optional variable, that has a much
            longer name than the other args, and which does nothing.

    Returns:
        A dict mapping keys to the corresponding table row data
        fetched. Each row is represented as a tuple of strings. For
        example:

        {'Serak': ('Rigel VII', 'Preparer'),
         'Zim': ('Irk', 'Invader'),
         'Lrrr': ('Omicron Persei 8', 'Emperor')}

        If a key from the keys argument is missing from the dictionary,
        then that row was not found in the table.

    Raises:
        IOError: An error occurred accessing the bigtable.Table object.
    """
    pass
  ```
  
- Python类的注释. 在类定义下有一个用于描述该类的文档字符串. 如果类有公共属性(Attributes), 那么文档中应该有一个属性(Attributes)段. 

  ```python
  class SampleClass(object):
    """Summary of class here.

    Longer class information....
    Longer class information....

    Attributes:
        likes_spam: A boolean indicating if we like SPAM or not.
        eggs: An integer count of the eggs we have laid.
    """

    def __init__(self, likes_spam=False):
        """Inits SampleClass with blah."""
        self.likes_spam = likes_spam
        self.eggs = 0

    def public_method(self):
        """Performs operation blah."""
  ```
