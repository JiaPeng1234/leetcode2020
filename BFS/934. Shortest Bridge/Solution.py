# https://leetcode.com/problems/shortest-bridge/

# By Jiapeng
# using bidirectional BFS + DFS
# 这道题目没有必要用双向BFS，因为操作的对象是一对坐标，所以可以直接在题目所给的静态数组上面做“标记”
# 毕竟两个Set或者两个Map等搜索速度再快也不如静态数组快
# 推荐使用Solution2
# Runtime: 632 ms, faster than 31.41% of Python3 online submissions for Shortest Bridge.
# Memory Usage: 16.4 MB, less than 46.29% of Python3 online submissions for Shortest Bridge.
class Solution:
    def shortestBridge(self, A: List[List[int]]) -> int:
        """
        step 1: color one of the two island to number 2
        step 2: put each island into one set
        step 3: begin bidirectional BFS from the two set
        Reference: if having problem using bidirectional BFS, then check out the 3rd python solution of leetcode 127
        """
        def dfs(x, y):
            if x < 0 or y < 0 or x >= xn or y >= yn or A[x][y] != 1:
                return
            A[x][y] = 2
            dfs(x+1, y)
            dfs(x-1, y)            
            dfs(x, y+1)            
            dfs(x, y-1)  
            
        s2, s1 = set(), set()
        xn, yn = len(A), len(A[0])
        exit_flag = False
        for i in range(xn):
            for j in range(yn):
                if A[i][j] == 1:
                    dfs(i, j)
                    exit_flag = True
                    break
            if exit_flag:
                break       # here notice, if one island is marked 2, then just break all for-loops
        
        for i in range(xn):
            for j in range(yn):
                if A[i][j] == 1:
                    s1.add((i, j))
                elif A[i][j] == 2:
                    s2.add((i, j))
                    
        # begin bidirectional BFS
        steps = 0
        while(s1 and s2):
            if len(s1) > len(s2):
                s1, s2 = s2, s1
            s = set()
            size = len(s1)
            while size:
                size -= 1
                row, col = s1.pop()
                for x, y in [(row + 1, col), (row - 1, col), (row, col + 1), (row, col - 1)]:
                    if x < 0 or x >= xn or y < 0 or y >= yn or A[x][y] == A[row][col]:
                        continue
                    if (x, y) in s2:
                        return steps
                    s.add((x, y))
                    A[x][y] = A[row][col]
            s1 = s
            steps += 1
                    
# By Jiapeng
# using normal BFS + DFS
# Runtime: 508 ms, faster than 54.78% of Python3 online submissions for Shortest Bridge.
# Memory Usage: 16.1 MB, less than 54.14% of Python3 online submissions for Shortest Bridge.
class Solution2:
    def shortestBridge(self, A: List[List[int]]) -> int:
        """
        step 1: color one of the two island to number 2
        step 2: put all node of this island to a queue
        step 3: begin BFS from the queue, when meets a node whose value is 1, return steps
        """
        def dfs(x, y, q):
            if x < 0 or y < 0 or x >= xn or y >= yn or A[x][y] != 1:
                return
            A[x][y] = 2
            q.append((x, y))
            dfs(x+1, y, q)
            dfs(x-1, y, q)
            dfs(x, y+1, q)
            dfs(x, y-1, q)
            
        q = collections.deque([])
        xn, yn = len(A), len(A[0])
        exit_flag = False
        for i in range(xn):
            for j in range(yn):
                if A[i][j] == 1:
                    dfs(i, j, q)
                    exit_flag = True
                    break
            if exit_flag:
                break       # here notice, if one island is marked 2, then just break all for-loops
                    
        # BFS
        steps = 0
        while(q):
            size = len(q)
            while size:
                size -= 1
                row, col = q.popleft()
                for x, y in [(row + 1, col), (row - 1, col), (row, col + 1), (row, col - 1)]:
                    if x < 0 or x >= xn or y < 0 or y >= yn or A[x][y] == 2:
                        continue
                    if A[x][y] == 1:
                        return steps
                    q.append((x, y))
                    A[x][y] = 2
            steps += 1
