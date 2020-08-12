# https://leetcode.com/problems/combinations/

# By jiapeng
# Runtime: 116 ms, faster than 83.44% of Python3 online submissions for Combinations.
# Memory Usage: 15.2 MB, less than 46.49% of Python3 online submissions for Combinations.

class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        if k>n:
            return []
        ans = []
        self.dfs(0, k, n, [], ans, 1)
        return ans
        
    def dfs(self, d, k, n, cur, ans, starter):
        if d==k:
            ans.append(cur)
            return
        for i in range(starter, n+1):
            if n+2-i<k-d:    # if there are less selectable numbers remaining than required, break the loop
                break
            self.dfs(d+1, k, n, cur+[i], ans, i+1)
