# https://leetcode.com/problems/evaluate-division/

# from Jiapeng
# dfs + graph, O(e + q*e)
# Runtime: 24 ms, faster than 94.18% of Python3 online submissions for Evaluate Division.
# Memory Usage: 14.2 MB, less than 99.97% of Python3 online submissions for Evaluate Division.

class Solution:
    def calcEquation(self, equations: List[List[str]], values: List[float], queries: List[List[str]]) -> List[float]:
        map = collections.defaultdict(dict)
        for (a, b), v in zip(equations, values):
            map[a][b] = v
            map[b][a] = 1.0 / v
        ans = []
        for x, y in queries:
            ans.append(self.dfs(x, y, 1, map, set()))
        return ans
            
    def dfs(self, x, y, v, map, visited):
        if x not in map or y not in map:
            return -1
        if x == y:
            return v
        visited.add(x)
        for i in map[x]:
            if i in visited:
                continue
            a = self.dfs(i, y, v * map[x][i], map, visited)
            if a > 0: return a      # important, according to whether a > 0 to assess whether target is found or not
        return -1
