# https://leetcode.com/problems/subsets/

# By jiapeng
# Runtime: 36 ms, faster than 72.49% of Python3 online submissions for Subsets.
# Memory Usage: 14 MB, less than 55.63% of Python3 online submissions for Subsets.

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        ans = []
        l = len(nums)
        for i in range(l+1):
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
            if l-d > len(nums)-starter: # if there are not enough numbers for cur of l-length, break
                break
            self.dfs(d+1, l, nums, ans, cur+[nums[i]], i+1)
