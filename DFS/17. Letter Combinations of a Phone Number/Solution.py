# https://leetcode.com/problems/letter-combinations-of-a-phone-number/

# By jiapeng
# using general dfs framework :)  dfs framework just OP 
# Runtime: 28 ms, faster than 84.31% of Python3 online submissions for Letter Combinations of a Phone Number.
# Memory Usage: 13.6 MB, less than 96.94% of Python3 online submissions for Letter Combinations of a Phone Number.

class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        if not digits:
            return []
        mapp = {"2": "abc",
               "3": "def",
               "4": "ghi",
               "5": "jkl",
               "6": "mno",
               "7": "pqrs",
               "8": "tuv",
               "9": "wxyz"
              }
        ans = []
        self.dfs(mapp, digits, ans, "", 0)
        return ans
        
    def dfs(self, mapp, digits, ans, cur, starter):
        if len(cur)==len(digits):
            ans.append(cur)
            return
        for i in range(starter, len(digits)):
            # here: similar to combination problem, but we dont need a "jump" in selecting letters
            # every bit of the value digits should be filled, so break when i!=starter
            if i!=starter:
                break
            for j in mapp[digits[i]]:
                cur += j
                self.dfs(mapp, digits, ans, cur, i+1)
                cur = cur[:-1]
                
                
# By jiapeng
# using core idea of dynamic programming: every time we add a new bit, just combine it with all the availble element in current output array
# Runtime: 20 ms, faster than 99.02% of Python3 online submissions for Letter Combinations of a Phone Number.
# Memory Usage: 13.9 MB, less than 36.02% of Python3 online submissions for Letter Combinations of a Phone Number.

class Solution2:
    def letterCombinations(self, digits: str) -> List[str]:
        if not len(digits):
            return []
        mobilemap={'0':[" "],
             '1':[],
             '2':['a','b','c'],
             '3':['d','e','f'],
             '4':['g','h','i'],
             '5':['j','k','l'],
             '6':['m','n','o'],
             '7':['p','q','r','s'],
             '8':['t','u','v'],
             '9':['w','x','y','z']}
        ans=[""]    # important, "" needs to be here
        for digit in digits:
            tmp=[]
            for digit_letter in mobilemap[digit]:
                for i in ans:
                    tmp.append(i+digit_letter)
            ans=tmp
        return ans
