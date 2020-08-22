# https://leetcode.com/problems/restore-ip-addresses/

# By Jiapeng
# DFS partition problem
# Runtime: 40 ms, faster than 53.06% of Python3 online submissions for Restore IP Addresses.
# Memory Usage: 13.7 MB, less than 90.70% of Python3 online submissions for Restore IP Addresses.
# DFS框架参考5：此方法可以作为DFS参考框架
class Solution:
    def restoreIpAddresses(self, s: str) -> List[str]:
        ans = []
        self.dfs(s, 0, ans, "", 0)
        return ans
    
    def dfs(self, s, count, ans, cur, starter):
        if count == 4:
            if starter == len(s):
                ans.append(cur[:-1])
            return
        for i in range(starter, len(s)):
            if i != starter:        # VERY IMPORTANT: 
                break               # 这个是为了防止不连续取数，所有分段问题都有类似这样的break条件
                                    # if not adding this, then the test result is like this:
                                    #
                                    # Wrong Answer:
                                    # Your input
                                    # "25525511135"
                                    # Output
                                    # ["2.5.5.135","2.5.5.35","2.5.5.5","2.5.52.135","2.5.52.35","2.5.52.5","2...
                                    # Expected
                                    # ["255.255.11.135","255.255.111.35"]
            self.dfs(s, count + 1, ans, cur + s[i] + '.', i + 1)    # for 1-digit IP
            if i + 2 <= len(s) and s[i] != '0':     # for 2-digits IP
                self.dfs(s, count + 1, ans, cur + s[i:i+2] + '.', i + 2)
                if i + 3 <= len(s) and s[i:i+3] <= "255":   # for 3-digits IP
                    self.dfs(s, count + 1, ans, cur + s[i:i+3] + '.', i + 3)
