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

/**
By Jiapeng
optimized method 
Runtime: 1 ms, faster than 100.00% of Java online submissions for Letter Case Permutation.
Memory Usage: 40.6 MB, less than 51.76% of Java online submissions for Letter Case Permutation.
**/
class Solution2 {
    public List<String> letterCasePermutation(String S) {
        List<String> ans = new ArrayList(); 
        // String本质上是字符数组，所以此处把S转换为char[]遍历更为节省时间
        // optimize here: use char[] array instead of String, cause essentially the Class String is a char array
        dfs(0, S, ans, S.toCharArray(), 0);
        return ans;
    }
    
    private void dfs(int d, String S, List<String> ans, char[] cur, int starter){
        if(d == S.length()){
            ans.add(new String(cur));
            return;
        }
        for(int i=starter; i<S.length(); i++){
            if(i != starter)
                break;
            char bit = S.charAt(i);
            // if current bit is a letter
            // then this bit is either in upper- or lowercase
            // optimize here, no need to use for-loop and backtrack
            // just assign lowercase and uppercase letter one by one
            // char[] array is static
            if(Character.isLetter(bit)){    
                cur[i] = Character.toLowerCase(bit);
                dfs(d+1, S, ans, cur, i+1);
                cur[i] = Character.toUpperCase(bit);
                dfs(d+1, S, ans, cur, i+1);
            } else{
                cur[i] = bit;
                dfs(d+1, S, ans, cur, i+1);
            }
        }
    }
}
