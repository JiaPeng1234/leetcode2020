# https://leetcode.com/problems/combinations/

# By jiapeng
# Runtime: 92 ms, faster than 92.19% of Python3 online submissions for Combinations.
# Memory Usage: 15.2 MB, less than 67.51% of Python3 online submissions for Combinations.

class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        if k > n:
            return []
        ans = []
        self.dfs(0, k, n, [], ans, 1)
        return ans
        
    def dfs(self, d, k, n, cur, ans, starter):
        if d == k:
            ans.append(cur)
            return
        for i in range(starter, n+1):
            if n+1-i < k-d:    # if there are less selectable numbers remaining than required, break the loop
                break
            self.dfs(d+1, k, n, cur+[i], ans, i+1)
