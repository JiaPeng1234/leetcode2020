// https://leetcode.com/problems/restore-ip-addresses/

/**
By Jiapeng
DFS partition problem
Runtime: 8 ms, faster than 34.56% of Java online submissions for Restore IP Addresses.
Memory Usage: 40.3 MB, less than 26.72% of Java online submissions for Restore IP Addresses.
**/
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        dfs(s, ans, "", 0, 0);
        return ans;
    }
    
    private void dfs(String s, List<String> ans, String cur, int count, int starter){
        if(count == 4){
            if(starter == s.length())
                ans.add(cur.substring(0, cur.length() - 1));
            return;
        }
        for(int i = starter; i < s.length(); i++){
            if(i != starter)
                break;
            dfs(s, ans, cur + s.substring(i, i + 1) + '.', count + 1, i + 1);
            if(i + 1 < s.length() && !s.substring(i, i + 1).equals("0")){   // IMPORTANT: use equals() instead of ==
                dfs(s, ans, cur + s.substring(i, i + 2) + '.', count + 1, i + 2);
                if(i + 2 < s.length() && Integer.parseInt(s.substring(i, i + 3)) <= 255){
                    dfs(s, ans, cur + s.substring(i, i + 3) + '.', count + 1, i + 3);
                }
            }
        }
    }
}
