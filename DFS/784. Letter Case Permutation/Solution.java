// https://leetcode.com/problems/letter-case-permutation/

/**
By Jiapeng
Runtime: 8 ms, faster than 37.05% of Java online submissions for Letter Case Permutation.
Memory Usage: 40.5 MB, less than 61.32% of Java online submissions for Letter Case Permutation.
**/

class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> ans = new ArrayList(); 
        dfs(0, S, ans, "", 0);
        return ans;
    }
    
    private void dfs(int d, String S, List<String> ans, String cur, int starter){
        if(d == S.length()){
            ans.add(cur);
            return;
        }
        for(int i=starter; i<S.length(); i++){
            if(i != starter)
                break;
            char bit = S.charAt(i);
            // if current bit is a letter
            // then this bit is either in upper- or lowercase
            if(Character.isLetter(bit)){    
                for(char letter: new ArrayList<Character>(Arrays.asList(Character.toUpperCase(bit), Character.toLowerCase(bit)))) {
                    dfs(d+1, S, ans, cur+letter, i+1);
                }
            } else{
                dfs(d+1, S, ans, cur+bit, i+1);
            }
        }
    }
}
