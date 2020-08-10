/** by jiapeng
**/
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        dfs(candidates,target,ans,new ArrayList<Integer>(),0);
        return ans;
    }
    private void dfs(int[] candidates, int target, List<List<Integer>> ans, ArrayList<Integer> cur, int starter){
        if (target==0){
            ans.add(cur);
            return;
        }
        for(int i=starter; i<candidates.length; i++){
            if (candidates[i]>target)
                break;
            cur.add(candidates[i]);
            dfs(candidates, target-candidates[i], ans, new ArrayList<Integer>(cur), i);
            cur.remove(cur.size()-1);
        }
    }
}
