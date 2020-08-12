// https://leetcode.com/problems/combinations/

/**
By jiapeng
Runtime: 1 ms, faster than 100.00% of Java online submissions for Combinations.
Memory Usage: 40.8 MB, less than 76.27% of Java online submissions for Combinations.
**/

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList();
        if (k > n)
            return ans;
        dfs(0, k, n, new ArrayList(), ans, 1);
        return ans;
    }
    
    private void dfs(int d, int k, int n, List<Integer>cur, List<List<Integer>>ans, int starter){
        if(d == k){
            ans.add(new ArrayList(cur));
            return;
        }
        for(int i = starter; i < n+1; i++){
            if(n+1-i < k-d)
                break;
            cur.add(i);
            dfs(d+1, k, n, cur, ans, i+1);
            cur.remove(cur.size()-1);
        }
    }
}
