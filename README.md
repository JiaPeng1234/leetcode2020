# leetcode2020
leetcode 2020 guide by huahua

## Category
```
├─BFS
├─Binary Search
├─Binary Search Tree
├─DFS
│  ├─17. Letter Combinations of a Phone Number
│  ├─39. Combination Sum
│  ├─40. Combination Sum II
│  ├─46. Permutation
│  └─77. Combinations
├─Dynamic Programming
├─Graph
├─List
├─Tree
└─旧表

```

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
- 算术运算符两边都加上一个空格.  

  ```python
  Yes: x = 1 + 2
  ```
  ```python
  No:  x = a/3
  ```
  例外：在if等条件句或是函数的参数中时不加空格.  
  
  ```python
  Yes: if x = 1+2:
  ```
  ```python
  No:  if x = a / 3:
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
