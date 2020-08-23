# https://leetcode.com/problems/different-ways-to-add-parentheses/

# By Jiapeng
# 记忆化递归求解分段问题 partition problem
# Runtime: 32 ms, faster than 85.56% of Python3 online submissions for Different Ways to Add Parentheses.
# Memory Usage: 14.2 MB, less than 5.35% of Python3 online submissions for Different Ways to Add Parentheses.
class Solution:
    def diffWaysToCompute(self, input: str) -> List[int]:
        """
        记忆化递归
        每一段s都可以以一个运算符号为界分成左右两边，左边式一个集合，右边是一个集合
        根据运算符号的不同求左右两边集合对应的笛卡尔积集合
        for循环中计算出的所有笛卡尔积集合做并集，得出当前递归的结果并返回
        同时把返回值都存在dict里面方便再用的时候查找（记忆化）
        当发现当前递归求出的笛卡尔积集合是空集的时候，说明该段input无运算符号，已经分解至只剩数字，此时直接返回带有该数字的list即可
        """
        def ways(s):
            if array[s]:
                return array[s]
            cur = []
            for i in range(len(s)):
                if s[i] in '+-*':
                    left = ways(s[:i])
                    right = ways(s[i+1:])
                    for l in left:
                        for r in right:
                            cur.append(opts[s[i]](l, r))
            if not cur:
                cur.append(int(s))
            array[s] = cur
            return cur
        
        array = collections.defaultdict(list)
        opts = {'+': lambda a, b: a + b,
                '-': lambda a, b: a - b,
                '*': lambda a, b: a * b}
        return ways(input)
    
       
