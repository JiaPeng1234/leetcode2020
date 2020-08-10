# from jiapeng
# Runtime: 32 ms, faster than 99.80% of Python3 online submissions for Combination Sum II.
# Memory Usage: 13.8 MB, less than 82.27% of Python3 online submissions for Combination Sum II.
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
            # need to ensure when i equals i-1, then it must be the first element that being tranversed in the current loop     
            if i!=starter and candidates[i]==candidates[i-1]:
                continue
            self.dfs(target-candidates[i], candidates, cur+[candidates[i]], ans, i+1)
