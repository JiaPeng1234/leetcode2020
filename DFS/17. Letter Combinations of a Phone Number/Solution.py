By jiapeng
using general dfs framework :)  dfs framework just OP 
Runtime: 28 ms, faster than 84.31% of Python3 online submissions for Letter Combinations of a Phone Number.
Memory Usage: 13.6 MB, less than 96.94% of Python3 online submissions for Letter Combinations of a Phone Number.

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
                
