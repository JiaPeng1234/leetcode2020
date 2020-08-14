# https://leetcode.com/problems/permutations-ii/

# By Jiapeng
# Runtime: 64 ms, faster than 63.07% of Python3 online submissions for Permutations II.
# Memory Usage: 14 MB, less than 52.23% of Python3 online submissions for Permutations II.
# DFS框架参考3：此方法可以作为DFS参考框架
class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        ans = []
        mask = [0] * len(nums)
        self.dfs(0, nums, ans, [], mask)    # 注意点1：不使用starter，而是使用一个相等大小的mask数组来标记该元素用过没有
        return ans
        
    def dfs(self, d, nums, ans, cur, mask):
        if d == len(nums):
            ans.append(cur)
            return
        for i in range(0, len(nums)):
            # 注意点2：剪枝条件continue
            # 和 https://github.com/XincredibleY/leetcode2020/blob/master/DFS/40.%20Combination%20Sum%20II/Solution.py 中的continue剪枝条件相对比
            if i > 0 and nums[i] == nums[i-1] and mask[i-1] == 0:
                continue
            if mask[i] == 1:
                continue
            mask[i] = 1
            self.dfs(d+1, nums, ans, cur+[nums[i]], mask)
            mask[i] = 0
