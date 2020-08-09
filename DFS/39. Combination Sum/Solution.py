# by jiapeng
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        ans = []
        candidates.sort()
        self.dfs(candidates,target,0,[],ans)
        return ans
    
    def dfs(self,candidates,target,s,cur,ans):
        if target==0:
            ans.append(cur)
            return
        for i in range(s,len(candidates)):
            if candidates[i]>target:
                break
            self.dfs(candidates,target-candidates[i],i,cur+[candidates[i]],ans)
