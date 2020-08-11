// https://leetcode.com/problems/combination-sum/

/** 
by jiapeng
Runtime: 2 ms, faster than 99.55% of Java online submissions for Combination Sum.
Memory Usage: 39.9 MB, less than 56.60% of Java online submissions for Combination Sum.
**/
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        dfs(candidates,target,ans,new ArrayList<Integer>(),0); // need to create a new Obj when append, can also do this when recursively calling dfs (line 24)
        return ans;
    }
    private void dfs(int[] candidates, int target, List<List<Integer>> ans, ArrayList<Integer> cur, int starter){
        if (target==0){
            ans.add(new ArrayList<Integer>(cur));
            return;
        }
        for(int i=starter; i<candidates.length; i++){
            if (candidates[i]>target)
                break;
            cur.add(candidates[i]);
            // dfs(candidates, target-candidates[i], ans, new ArrayList<Integer>(cur), i);
            dfs(candidates, target-candidates[i], ans, cur, i);
            cur.remove(cur.size()-1);
        }
    }
}
