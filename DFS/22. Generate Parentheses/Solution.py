# https://leetcode.com/problems/generate-parentheses/

# By Jiapeng
# Runtime: 24 ms, faster than 98.88% of Python3 online submissions for Generate Parentheses.
# Memory Usage: 14.2 MB, less than 29.90% of Python3 online submissions for Generate Parentheses.
# DFS框架参考2：此方法可以作为DFS参考框架
class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        ans = []
        self.dfs(n, n, "", ans)
        return ans
    
    def dfs(self, left, right, cur, ans):
        # 注意点1 剪枝条件，剪枝条件根据题目的不同也可以写在出口条件之前，比如这道题回溯的变量和出口条件涉及到的是同一个变量（left和right）
        # 此时可以把剪枝条件写在出口条件之前，其作用相当于for循环里的continue
        if left > right or left < 0 or right < 0:   # don't forget to set the boundary condition left < 0 and right < 0
            return
        if right == left == 0:  # 注意点2 此处是出口条件
            ans.append(cur)
            return
        # 注意点3 此处没有使用for循环，只是把两种可能性one by one地回溯
        left -= 1
        self.dfs(left, right, cur+"(", ans)
        left += 1
        right -= 1
        self.dfs(left, right, cur+")", ans)
        right += 1
