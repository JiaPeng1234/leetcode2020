# https://leetcode.com/problems/01-matrix/

# By Jiapeng
# BFS+mask, update matrix[x][y] with the variable steps
# Runtime: 812 ms, faster than 57.97% of Python3 online submissions for 01 Matrix.
# Memory Usage: 16.6 MB, less than 53.19% of Python3 online submissions for 01 Matrix.
class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        """
        # step 1: create a full zero "map", all zeros in the map is set to 1
        # step 2: use BFS, initialize the queue with all coordinate of zeros
        # step 3: zeros begin to diffuse to its non-zero adjacent cells, update them with step 
        # step 4: the cells that have already been checked should be added to "map" created in step 1
        """
        if len(matrix) == 0 or len(matrix[0]) == 0:
            return matrix
        mapp = [[0] * len(matrix[0]) for _ in range(len(matrix))]
        q = collections.deque()     # using deque can improve efficiency
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                if matrix[i][j] == 0:
                    q.append((i, j))
                    mapp[i][j] = 1
        adjacent = [-1, 0, 1, 0, -1]
        steps = 0
        while q:
            size = len(q)
            while size:
                size -= 1
                node = q.popleft()
                for i in range(4):
                    x = node[0] + adjacent[i]
                    y = node[1] + adjacent[i+1]
                    if x < 0 or y < 0 or x >= len(matrix) or y >= len(matrix[0]) or mapp[x][y] == 1:
                        continue
                    q.append((x, y))
                    mapp[x][y] = 1
                    matrix[x][y] = steps + 1
            steps += 1
        return matrix
      
# By 
