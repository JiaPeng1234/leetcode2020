// https://leetcode.com/problems/palindrome-partitioning/

/**
By Jiapeng
DFS partition problem
Runtime: 1 ms, faster than 100.00% of Java online submissions for Palindrome Partitioning.
Memory Usage: 40.4 MB, less than 69.48% of Java online submissions for Palindrome Partitioning.
**/
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        dfs(s, 0, ans, new ArrayList<String>());
        return ans;
    }
    
    private void dfs(String s, int starter, List<List<String>> ans, List<String> cur){
        if(starter == s.length()){
            ans.add(new ArrayList<>(cur));
            return;
        }
        for(int i = starter; i < s.length(); i++){
            if(!isPalindrome(s, starter, i))
                continue;
            cur.add(s.substring(starter, i + 1));
            dfs(s, i + 1, ans, cur);
            cur.remove(cur.size() - 1);
        }
    }
    
    private boolean isPalindrome(String s, int left, int right){
        while(left < right){
            if(s.charAt(left++) != s.charAt(right--))
               return false;
        }
        return true;
    }
}
