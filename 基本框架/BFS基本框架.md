## 1. 基础模板
```
q = new HashSet()
seen = new HashSet()
q.add(start)
steps = 0
while not q.empty():
    size = q.size()
    while size-- >0: 
        state=q.pop()
        if is_goal(state):
            return steps
        for new_state in expend(state):
            if not valid(new_state):
                continue
            q.add(new_state)
            seen.add(new_state)
    ++steps
return -1
```

## 2. 几种典型模板

按照顺序观看：

1. 参考127. Word Ladder 的python解法Solution1：
https://github.com/XincredibleY/leetcode2020/blob/master/BFS/127.%20Word%20Ladder/Solution.py

2. 双向BFS，参考127. Word Ladder 的python解法Solution3：
https://github.com/XincredibleY/leetcode2020/blob/master/BFS/127.%20Word%20Ladder/Solution.py
