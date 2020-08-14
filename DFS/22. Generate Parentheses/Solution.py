# https://leetcode.com/problems/generate-parentheses/

# By Jiapeng
# Runtime: 24 ms, faster than 98.88% of Python3 online submissions for Generate Parentheses.
# Memory Usage: 14.2 MB, less than 29.90% of Python3 online submissions for Generate Parentheses.

class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        ans = []
        self.dfs(n, n, "", ans)
        return ans
    
    def dfs(self, left, right, cur, ans):
        if left > right or left < 0 or right < 0:   # don't forget to set the boundary condition left < 0 and right < 0
            return
        if right == left == 0:
            ans.append(cur)
            return
        left -= 1
        self.dfs(left, right, cur+"(", ans)
        left += 1
        right -= 1
        self.dfs(left, right, cur+")", ans)
        right += 1
