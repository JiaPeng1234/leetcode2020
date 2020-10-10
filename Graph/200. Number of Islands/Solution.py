# https://leetcode.com/problems/number-of-islands/

# By Jiapeng
# DFS
# Runtime: 140 ms, faster than 82.64% of Python3 online submissions for Number of Islands.
# Memory Usage: 15.2 MB, less than 5.37% of Python3 online submissions for Number of Islands.

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        count = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == '1':
                    self.dfs(grid, i, j)
                    count += 1
        return count
        
    def dfs(self, grid, x, y):
        if x >= 0 and y >= 0 and x < len(grid) and y < len(grid[0]) and grid[x][y] == '1':
            grid[x][y] = '0'
            self.dfs(grid, x + 1, y)
            self.dfs(grid, x, y + 1)            
            self.dfs(grid, x - 1, y)            
            self.dfs(grid, x, y - 1)       
