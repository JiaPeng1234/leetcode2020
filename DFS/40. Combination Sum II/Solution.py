# from jiapeng
# Runtime: 32 ms, faster than 99.80% of Python3 online submissions for Combination Sum II.
# Memory Usage: 13.8 MB, less than 82.27% of Python3 online submissions for Combination Sum II.
# 此方法可以作为DFS参照框架
class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        ans = []
        candidates.sort()   # 注意点1 sort
        self.dfs(target, candidates, [], ans, 0)
        return ans
                
    def dfs(self, target, candidates, cur, ans, starter):
        if target == 0:     # 注意点2 出口条件
            ans.append(cur)     # 注意点3 append的必须是cur的拷贝 和注意点7 相结合考虑
            return
        for i in range(starter, len(candidates)):   # 注意点4 使用starter从下一个元素开始遍历
            if candidates[i]>target:    # 注意点5 剪枝条件 break 不符合该条件就一票否决for循环后面所有元素
                break
            # need to ensure when i equals i-1, then it must be the first element that being tranversed in the current loop     
            if i!=starter and candidates[i]==candidates[i-1]:   # 注意点6 剪枝条件 continue 不符合该条件说明存在重复答案等情况，使用continue跳过这个元素，继续遍历for循环后面的元素
                continue
            self.dfs(target-candidates[i], candidates, cur+[candidates[i]], ans, i+1)   # 注意点7 要保证注意点3 处是append的cur的拷贝，同时还要保证进行了回溯
