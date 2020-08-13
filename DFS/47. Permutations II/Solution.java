// https://leetcode.com/problems/permutations-ii/

/**
By Jiapeng
Runtime: 40 ms, faster than 97.90% of Python3 online submissions for Combination Sum II.
Memory Usage: 13.9 MB, less than 37.81% of Python3 online submissions for Combination Sum II.
**/

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int[] mask = new int[nums.length];
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        dfs(0, nums, ans, new ArrayList(), mask);
        return ans;
    }
    
    private void dfs(int d, int[] nums, List<List<Integer>> ans, List<Integer> cur, int[] mask){
        if(d == nums.length){
            ans.add(new ArrayList(cur));
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(mask[i] == 1)
                continue;
            if(i > 0 && nums[i] == nums[i-1] && mask[i-1] == 0)
                continue;
            mask[i] = 1;
            cur.add(nums[i]);
            dfs(d+1, nums, ans, cur, mask);
            cur.remove(cur.size()-1);
            mask[i] = 0;
        }
    }
}
