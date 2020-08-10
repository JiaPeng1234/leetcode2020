class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        ans = []
        candidates.sort()
        self.dfs(target, candidates, [], ans, 0)
        return ans
                
    def dfs(self, target, candidates, cur, ans, starter):
        if target == 0:
            ans.append(cur)
            return
        for i in range(starter, len(candidates)):
            if candidates[i]>target:
                break
            if i!=starter and candidates[i]==candidates[i-1]:
                continue
            self.dfs(target-candidates[i], candidates, cur+[candidates[i]], ans, i+1)
