# https://leetcode.com/problems/palindrome-partitioning/

# By Jiapeng
# DFS partition problem
# Runtime: 92 ms, faster than 56.86% of Python3 online submissions for Palindrome Partitioning.
# Memory Usage: 14.3 MB, less than 20.58% of Python3 online submissions for Palindrome Partitioning.
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        ans = []
        self.dfs(ans, [], 0, s)
        return ans
        
    def dfs(self, ans, cur, starter, s):
        if starter == len(s):
            ans.append(cur)
            return
        for i in range(starter, len(s)):
            if not self.isPalindrome(s, starter, i):
                continue
            self.dfs(ans, cur + [s[starter:i+1]], i + 1, s)
    
    def isPalindrome(self, s, left, right):
        while left < right:
            if s[left] != s[right]:
                return False
            left += 1
            right -= 1
        return True
