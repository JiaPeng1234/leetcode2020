# https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/

# from Jiapeng
# two pointer
# Runtime: 224 ms, faster than 75.40% of Python3 online submissions for Pairs of Songs With Total Durations Divisible by 60.
# Memory Usage: 18 MB, less than 50.24% of Python3 online submissions for Pairs of Songs With Total Durations Divisible by 60.

class Solution:
    def numPairsDivisibleBy60(self, time: List[int]) -> int:
        dic = collections.defaultdict(int)
        count = 0
        for i in time:
            i = i%60
            target = (60-i)%60
            if target in dic:
                count += dic[target]
            dic[i] += 1
        return count
     
# Compared with Solution 1, take advantage of using "static" list instead of  dictionary     
# Runtime: 204 ms, faster than 97.35% of Python3 online submissions for Pairs of Songs With Total Durations Divisible by 60.
# Memory Usage: 18 MB, less than 50.24% of Python3 online submissions for Pairs of Songs With Total Durations Divisible by 60.   

class Solution2:
    def numPairsDivisibleBy60(self, time: List[int]) -> int:
        arr = [0] * 60
        for t in time:
            arr[t % 60] += 1
        res = 0
        for i in range(31):
            if i == 0 or i == 30:
                res += (arr[i] * (arr[i]-1)) // 2
            else:
                res += arr[60-i] * arr[i]
        return res
