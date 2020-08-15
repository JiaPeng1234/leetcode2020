# https://leetcode.com/problems/word-search/

# By Jiapeng
# Runtime: 364 ms, faster than 74.90% of Python3 online submissions for Word Search.
# Memory Usage: 15 MB, less than 71.50% of Python3 online submissions for Word Search.
# DFS框架参考4：此方法可以作为DFS参考框架

class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        # TODO: 根据题目Constraint分析bigO
        xn = len(board)
        yn = len(board[0])
        for x in range(xn):
            for y in range(yn):
                if self.dfs(0, x, y, board, word):  # skillz! recursively returning True
                    return True
        return False
    
    def dfs(self, d, x, y, board, word):
        if d == len(word):
            return True
        # pruning
        if x >= len(board) or x < 0 or y >= len(board[0]) or y < 0 or word[d] != board[x][y]:
            return False
        
        # what's special here: backtracking before for-loop
        tmp = board[x][y]   # backtracking, save original value
        board[x][y] = -1    # change (x,y) to a value thats impossibly pass the pruning condition above
        flag = self.dfs(d+1, x, y+1, board, word) or \
        self.dfs(d+1, x+1, y, board, word) or \
        self.dfs(d+1, x, y-1, board, word) or \
        self.dfs(d+1, x-1, y, board, word)
        board[x][y] = tmp
        
        return flag
