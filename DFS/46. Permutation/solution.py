https://leetcode.com/problems/permutations/
# Jiacheng Yang
# Runtime: 36 ms
# Memory Usage: 13.8 MB
class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        n = len(nums)
        res = []
        visited = [0] * n
        
        def dfs(nums, visited, curr):
            if len(curr) == n:
                res.append(curr)
            for i in range(n):      # 每次i都是从0开始，因为可以往回找，visited来控制哪些找过
                if visited[i] == 0:
                    visited[i] = 1
                    dfs(nums, visited, curr + [nums[i]])
                    visited[i] = 0
        dfs(nums, visited, [])
        return res
