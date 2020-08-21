# https://leetcode.com/problems/partition-to-k-equal-sum-subsets/

# By Jiapeng
class Solution:
    def canPartitionKSubsets(self, nums: List[int], k: int) -> bool:
        if k == 1:
            return True
        
        add = sum(nums)
        if add % k or k > len(nums):
            return False
        
        target = add / k
        nums.sort(reverse=True)
        if nums[0] > target:
            return False
        
        def dfs(target, rest, mask, k):
            if rest == 0:
                k -= 1
                rest = target
            if k == 0:
                return True
            for i in range(0, len(nums)):
                if mask[i] or nums[i] > rest:
                    continue
                mask[i] = 1
                if dfs(target, rest-nums[i], mask, k):
                    return True
                mask[i] = 0
            return False
        
        mask = [0] * len(nums)
        return dfs(target, target, mask, k)
