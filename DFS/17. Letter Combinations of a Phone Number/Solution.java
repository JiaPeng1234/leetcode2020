// https://leetcode.com/problems/letter-combinations-of-a-phone-number/

/**
By jiapeng
using dfs framework
Runtime: 5 ms, faster than 44.51% of Java online submissions for Letter Combinations of a Phone Number.
Memory Usage: 39.8 MB, less than 42.03% of Java online submissions for Letter Combinations of a Phone Number.
**/

class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<Character, char []> map = new HashMap<>();  // could use HashMap<Charater, String> as well
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
        List<String> ans = new ArrayList();
        if(digits!=null && digits.length()>0)
            dfs(digits, map, ans, "", 0);
        return ans;
    }
    
    private void dfs(String digits, HashMap<Character, char []> map, List<String> ans, String cur, int starter){
        if(digits.length()==cur.length()){
            ans.add(cur);  // no need to use new String(cur), it will be duplicated automaticlly due to String.Class feature
            return;
        }
        for(int i=starter; i<digits.length(); i++){
            if(i!=starter)
                break;
            for(char j: map.get(digits.charAt(i))){
                cur += j;
                dfs(digits, map, ans, cur, i+1);
                cur = cur.substring(0, cur.length()-1);
            }
        }
    }
}
