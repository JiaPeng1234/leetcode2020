// https://leetcode.com/problems/split-array-into-fibonacci-sequence/

/**
By Jiapeng
DFS 
Runtime: 1 ms, faster than 100.00% of Java online submissions for Split Array into Fibonacci Sequence.
Memory Usage: 38 MB, less than 87.55% of Java online submissions for Split Array into Fibonacci Sequence.
**/
class Solution {
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> ans = new ArrayList<>();
        dfs(S, 0, ans);
        return ans;
    }
    
    private boolean dfs(String S, int starter, List<Integer> ans){
        if(starter == S.length() && ans.size() >= 3){
            return true;
        }
        long num = 0;
        for(int end = starter; end < Math.min(starter + 10, S.length()); end++){
            num = num*10 + (S.charAt(end)-'0');
            if(num > Integer.MAX_VALUE || (end > starter && S.charAt(starter) == '0'))
                break;
            if(ans.size() >= 2 && num != ans.get(ans.size()-1) + ans.get(ans.size()-2))
                continue;
            ans.add((int)num);    // mind converting long to int (here long num is smaller than Integer.MAX_VALUE)
            if(dfs(S, end + 1, ans))
                return true;
            ans.remove(ans.size() - 1);
        }
        return false;
    }
}
