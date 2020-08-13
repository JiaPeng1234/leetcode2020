# https://leetcode.com/problems/subsets-ii/

# By jiapeng
# Runtime: 40 ms, faster than 70.25% of Python3 online submissions for Subsets II.
# Memory Usage: 14 MB, less than 52.85% of Python3 online submissions for Subsets II.

class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        ans = []
        for i in range(len(nums)+1):
            self.dfs(0, i, nums, ans, [], 0)
        return ans
        
    def dfs(self, d, l, nums, ans, cur, starter):
        """
        traverse all possible answers of l-length
        
        Args:
            d: current length of cur
            l: target length of cur
            nums: the given distinct integers
            ans: final answer we want
            cur: one subset of ans in length l
            starter: index of the element our traverse start with
        """
        if d == l:
            ans.append(cur)
            return
        for i in range(starter, len(nums)):
            if l-d > len(nums)-i:
                break
            if i!=starter and nums[i]==nums[i-1]:   # remove duplicate subsets when nums contains duplicates
                continue
            self.dfs(d+1, l, nums, ans, cur+[nums[i]], i+1)
