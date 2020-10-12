# https://leetcode.com/problems/course-schedule/

# By Jiapeng
# topology sorting
# Runtime: 92 ms, faster than 95.19% of Python3 online submissions for Course Schedule.
# Memory Usage: 16.1 MB, less than 5.98% of Python3 online submissions for Course Schedule.

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        visited = [0] * numCourses
        Map = collections.defaultdict(list)
        for key, item in prerequisites:
            Map[key].append(item)
        
        for i in range(numCourses):
            if self.dfs(i, Map, visited):
                return False
        return True
    
    def dfs(self, num, Map, visited):
        if visited[num] == 1:   # status == 1 indicates visiting nodes
            return True
        if visited[num] == 2:   # important! use two status, if status == 2 indicates already make sure all its prerequisites nodes no rings
            return False
        
        visited[num] = 1
        for i in Map[num]:
            if self.dfs(i, Map, visited):
                return True
        visited[num] = 2

        return False
            
