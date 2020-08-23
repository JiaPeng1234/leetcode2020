// https://leetcode.com/problems/different-ways-to-add-parentheses/

/**
By Jiapeng
记忆化递归
Runtime: 1 ms, faster than 99.68% of Java online submissions for Different Ways to Add Parentheses.
Memory Usage: 38.3 MB, less than 85.09% of Java online submissions for Different Ways to Add Parentheses.
**/
class Solution {
    private static Map<String, List<Integer>> arrays = new HashMap<>();
    
    public List<Integer> diffWaysToCompute(String input) {
        if(arrays.containsKey(input))
            return arrays.get(input);
        List<Integer> cur = new ArrayList<>();
        for(int i = 0; i < input.length(); i++){
            char ch = input.charAt(i);
            if(ch == '+' || ch == '-' || ch == '*'){
                for(Integer l: diffWaysToCompute(input.substring(0, i)))
                    for(Integer r: diffWaysToCompute(input.substring(i + 1))){
                        if(ch == '+') cur.add(l + r);
                        else if (ch == '-') cur.add(l - r);
                        else cur.add(l * r);
                    }
            }
        }
        if(cur.isEmpty())
            cur.add(Integer.parseInt(input));
        arrays.put(input, cur);
        return cur;
    }
}
