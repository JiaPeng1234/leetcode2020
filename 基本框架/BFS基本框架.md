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
