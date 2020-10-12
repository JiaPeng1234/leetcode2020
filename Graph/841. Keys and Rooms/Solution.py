# https://leetcode.com/problems/clone-graph/

# By Jiapeng
# DFS, connected components
# Runtime: 56 ms, faster than 98.84% of Python3 online submissions for Keys and Rooms.
# Memory Usage: 14.6 MB, less than 22.30% of Python3 online submissions for Keys and Rooms.

class Solution:
    def canVisitAllRooms(self, rooms: List[List[int]]) -> bool:
        N = len(rooms)
        visited = [0] * N
        self.dfs(visited, 0, rooms)
        return False if 0 in visited else True
    
    def dfs(self, visited, cur, rooms):
        visited[cur] = 1
        for key in rooms[cur]:
            if not visited[key]:
                self.dfs(visited, key, rooms)
