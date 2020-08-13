# https://leetcode.com/problems/letter-case-permutation/

# By Jiapeng
# Runtime: 64 ms, faster than 61.44% of Python3 online submissions for Letter Case Permutation.
# Memory Usage: 14.4 MB, less than 50.53% of Python3 online submissions for Letter Case Permutation.

class Solution:
    def letterCasePermutation(self, S: str) -> List[str]:
        ans =[]
        if S:
            self.dfs(0, S, ans, "", 0)
        return ans
        
    def dfs(self, d, S, ans, cur, starter):
        if d == len(S):
            ans.append(cur)
            return
        for i in range(starter, len(S)):
            if i != starter:
                break
            if S[i] not in "1234567890":
                for j in [S[i].upper(), S[i].lower()]:  # if S[i] in "abcdefg..." pick either uppercase or lowercase
                    self.dfs(d+1, S, ans, cur+j, i+1)
            else:
                self.dfs(d+1, S, ans, cur+S[i], i+1)
