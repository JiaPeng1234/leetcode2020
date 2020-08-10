// from jiapeng 
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List ans = new ArrayList();
        dfs(candidates, target, ans, new ArrayList(), 0);
        return ans;
    }
    
    private void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> cur, int starter){
        if(target == 0){
            ans.add(cur);
            return;
        }
        for(int i=starter; i<candidates.length; i++){
            if (candidates[i] > target)
                break;
            // need to ensure when i equals i-1, then it must be the first element that being tranversed in the current loop            
            if (i != starter && candidates[i]==candidates[i-1])
                continue;
            cur.add(candidates[i]);
            dfs(candidates, target - candidates[i], ans, new ArrayList(cur), i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}
