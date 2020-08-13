// https://leetcode.com/problems/subsets-ii/

/**
By jiapeng
Runtime: 1 ms, faster than 99.95% of Java online submissions for Subsets II.
Memory Usage: 39.9 MB, less than 59.04% of Java online submissions for Subsets II.
**/

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<=nums.length; i++)
            dfs(0, i, nums, ans, new ArrayList(), 0);
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
            if(i != starter && nums[i] == nums[i-1])
                continue;
            cur.add(nums[i]);
            dfs(d+1, l, nums, ans, cur, i+1);
            cur.remove(cur.size()-1);
        }
    }
}
