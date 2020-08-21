## 1. 基础模板
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

5. partition problem 参考698. Word Search的python解法Solution1：
https://github.com/XincredibleY/leetcode2020/blob/master/DFS/698.%20Partition%20to%20K%20Equal%20Sum%20Subsets/Solution.py
