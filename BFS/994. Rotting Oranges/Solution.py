# https://leetcode.com/problems/rotting-oranges/

# By Jiapeng
# Runtime: 64 ms, faster than 29.66% of Python3 online submissions for Rotting Oranges.
# Memory Usage: 13.8 MB, less than 71.22% of Python3 online submissions for Rotting Oranges.
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        """
        similar to 542. 01 Matrix
        check out the BFS approach of 542
        """
        fresh_count = 0
        q = collections.deque()   # 试验发现deque比list普遍略快一些
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 1:
                    fresh_count += 1
                elif grid[i][j] == 2:
                    q.append((i, j))
        if fresh_count == 0:    # 很重要，出口条件要么时判断本层，要么是判断下一层，该解法时判断下一层，所以我们要先排除本层就满足出口条件的可能性
            return 0
          
        steps = 0
        while q:
            size = len(q)
            while size:
                size -= 1
                row, col = q.popleft()
                for x,y in [(row, col+1), (row, col-1), (row+1, col), (row-1, col)]:
                    if x < 0 or y < 0 or x >= len(grid) or y >= len(grid[0]) or grid[x][y] != 1:
                        continue
                    grid[x][y] = 2
                    fresh_count -= 1
                    q.append((x, y))
                if fresh_count == 0:    # 出口条件，判断下一层是否满足出口条件
                    return steps + 1
            steps += 1
        return -1
