## 1. 模板
### a. DFS基本模板
```python
# code in python
nums=[...]
ans=[]
m=len(nums)
nums.sort()

# C(m,n)
func dfs(n,d,s,cur):
    if d==n:
        ans.append(cur[0:d])
        return
    for i=s to m-1:
        if i>s and nums[i]==nums[i-1]:
            continue    # 去重
        cur[d]=nums[i]
        dfs(n,d+1,i+1,cur)
        # 没有必要回溯，因为下次赋值会直接覆盖当前值且最终append的值是cur[0:d]
        # cur[d]=None   
        # hin: append&pop() 回溯不如直接赋值的回溯节省时间
        
for i=0 to m:   # 调用dfs
    dfs(i,0,0,[None]*i)
```
### b. DFS-partition问题模板

```python
# code in python
# 适用于连续分割问题
# 以131题python解法一为模板
def partition(self, s: str) -> List[List[str]]:
    ans = []
    self.dfs(ans, [], 0, s)
    return ans

def dfs(self, ans, cur, starter, s):
    """
    ans 最终答案
    cur 最终答案的一个子集
    starter 本次dfs递归分段开始的第一个字符的角标
    s 题目给的字符串
    """
    if starter == len(s):   # 如果starter已经是s最后一位的后一位了，说明字符串分割完毕
        ans.append(cur)
        return
    for end in range(starter, starter + length):  # end代表当前选取的这段字符串最后一位在s中的角标
        if end < len(s):    # end 最后一位不可以out of range
            if not self.isPalindrome(s, starter, end):   # 不符合条件，continue
                continue
            self.dfs(ans, cur + [s[starter:i+1]], end + 1, s)   # 以end+1作为starter开始下一次递归

def isPalindrome(self, s, left, right):
    blahblahblah
```
## 2. 几种典型模板

按照顺序观看：

1. 参考40. Combination Sum II 的python解法Solution1：
https://github.com/XincredibleY/leetcode2020/blob/master/DFS/40.%20Combination%20Sum%20II/Solution.py

2. 参考22. Generate Parentheses 的python解法Solution1：
https://github.com/XincredibleY/leetcode2020/blob/master/DFS/22.%20Generate%20Parentheses/Solution.py

3. 参考47. Permutations II 的python解法Solution1：
https://github.com/XincredibleY/leetcode2020/blob/master/DFS/47.%20Permutations%20II/Solution.py

4. 参考79. Word Search的python解法Solution1：
https://github.com/XincredibleY/leetcode2020/blob/master/DFS/79.%20Word%20Search/Solution.py

5. partition problem 参考698. Partition to K Equal Sum Subsets的python解法Solution1：
https://github.com/XincredibleY/leetcode2020/edit/master/DFS/698.%20Partition%20to%20K%20Equal%20Sum%20Subsets/Solution.py
以及：参考93. Restore IP Addresses的python解法Solution2：
https://github.com/XincredibleY/leetcode2020/blob/master/DFS/93.%20Restore%20IP%20Addresses/Solution.py
