// https://leetcode.com/problems/subsets/

/**
By jiapeng
Runtime: 1 ms, faster than 78.32% of Java online submissions for Subsets.
Memory Usage: 39.8 MB, less than 71.50% of Java online submissions for Subsets.
**/

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<=nums.length; i++)
            dfs(0, i, nums, ans, new ArrayList<Integer>(), 0);
        return ans;
    }
    
    private void dfs(int d, int l, int[] nums, List<List<Integer>> ans, List<Integer> cur, int starter){
        if(d == l){
            ans.add(new ArrayList(cur));
            return;
        }
        for(int i=starter; i<nums.length; i++){
            if(l-d > nums.length-i)
                break;
            cur.add(nums[i]);
            dfs(d+1, l, nums, ans, cur, i+1);
            cur.remove(cur.size()-1);
        }
    }
}
