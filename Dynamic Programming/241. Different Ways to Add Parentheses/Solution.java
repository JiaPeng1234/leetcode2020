// https://leetcode.com/problems/different-ways-to-add-parentheses/

/**
By Jiapeng
记忆化递归求解分段问题
Runtime: 1 ms, faster than 99.68% of Java online submissions for Different Ways to Add Parentheses.
Memory Usage: 38.3 MB, less than 85.09% of Java online submissions for Different Ways to Add Parentheses.
**/
class Solution {
    private static Map<String, List<Integer>> arrays = new HashMap<>();     // 记忆化每次递归结果
    
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
        if(cur.isEmpty())       // cur为空说明当前input不存在'+','-','*'符号
            cur.add(Integer.parseInt(input));
        arrays.put(input, cur);
        return cur;
    }
}

/**
By Jiapeng
和方法1一模一样，但是使用了传递函数的高级用法！！！
Runtime: 2 ms, faster than 63.20% of Java online submissions for Different Ways to Add Parentheses.
Memory Usage: 37.7 MB, less than 94.37% of Java online submissions for Different Ways to Add Parentheses.
**/
class Solution2 {
    private static Map<String, List<Integer>> arrays = new HashMap<>();
    private static Map<Character, BiFunction<Integer, Integer, Integer>> ops = new HashMap<>();     // Map存储对应的函数，详情参见java8函数式接口
    {                                                                                               // https://www.runoob.com/java/java8-functional-interfaces.html
        ops.put('+', (a, b) -> a + b);
        ops.put('-', (a, b) -> a - b);
        ops.put('*', (a, b) -> a * b);
    }
    public static Integer calc(BiFunction<Integer, Integer, Integer> bi, Integer l, Integer r) {    // 使用apply() call function
        return bi.apply(l, r);
    }
    public List<Integer> diffWaysToCompute(String input) {
        if(arrays.containsKey(input))
            return arrays.get(input);
        List<Integer> cur = new ArrayList<>();
        for(int i = 0; i < input.length(); i++){
            char ch = input.charAt(i);
            if(ch == '+' || ch == '-' || ch == '*'){
                for(Integer l: diffWaysToCompute(input.substring(0, i)))
                    for(Integer r: diffWaysToCompute(input.substring(i + 1))){
                        cur.add(calc(ops.get(ch), l, r));
                    }
            }
        }
        if(cur.isEmpty())
            cur.add(Integer.parseInt(input));
        arrays.put(input, cur);
        return cur;
    }
}
