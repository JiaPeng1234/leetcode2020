// https://leetcode.com/problems/permutations/

/**
By jiapeng
Runtime: 1 ms, faster than 95.21% of Java online submissions for Permutations.
Memory Usage: 39.9 MB, less than 53.75% of Java online submissions for Permutations.
**/

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] map = new int[nums.length];
        dfs(0, nums.length, nums, ans, new ArrayList<>(), map);
        return ans;
    }
    
    private void dfs(int d, int l, int[] nums, List<List<Integer>> ans, List<Integer> cur, int[] map){
        if(d == l){
            ans.add(new ArrayList(cur));
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(map[i] == 1)
                continue;
            cur.add(nums[i]);
            map[i] = 1;
            dfs(d+1, l, nums, ans, cur, map);
            cur.remove(cur.size()-1);
            map[i] = 0;
        }
    }
}
