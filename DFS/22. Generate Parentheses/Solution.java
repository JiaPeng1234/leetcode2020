// https://leetcode.com/problems/generate-parentheses/

/**
By Jiapeng
the code is so elegant!
Runtime: 1 ms, faster than 88.90% of Java online submissions for Generate Parentheses.
Memory Usage: 39.4 MB, less than 87.68% of Java online submissions for Generate Parentheses.
**/

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        dfs(n, n, ans, "");
        return ans;
    }
    
    private void dfs(int left, int right, List<String> ans, String cur){
        if(left > right || left < 0 || right < 0)
            return;
        if(left == 0 && right == 0){
            ans.add(cur);
            return;
        }
        dfs(left-1, right, ans, cur+"(");
        dfs(left, right-1, ans, cur+")");
    }
}
