# https://leetcode.com/problems/split-array-into-fibonacci-sequence/

# By Jiapeng
# DFS 这道题需要注意下边界最大值
# Runtime: 40 ms, faster than 84.78% of Python3 online submissions for Split Array into Fibonacci Sequence.
# Memory Usage: 13.7 MB, less than 87.46% of Python3 online submissions for Split Array into Fibonacci Sequence.
class Solution:
    def splitIntoFibonacci(self, S: str) -> List[int]:
        if len(S) == 0:
            return []
        self.ans = []
        self.dfs(S, 0, [])
        return self.ans
    
    def dfs(self, S, starter, cur):
        if starter == len(S) and len(cur) >= 3:
            self.ans = cur
            return True
        for end in range(starter, min(len(S), starter + 10)):    # 2^31 是十位数，最多十位数，很关键
            if S[starter] == '0' and end > starter or int(S[starter:end+1]) >= math.pow(2, 31):
                break
            if len(cur) >= 2 and int(S[starter:end+1]) != cur[-1] + cur[-2]:
                continue
            if self.dfs(S, end + 1, cur + [int(S[starter:end+1])]):
                return True
        return False
