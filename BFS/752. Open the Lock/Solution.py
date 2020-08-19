# https://leetcode.com/problems/open-the-lock/

# By Jiapeng
# Runtime: 544 ms, faster than 86.92% of Python3 online submissions for Open the Lock.
# Memory Usage: 15 MB, less than 37.13% of Python3 online submissions for Open the Lock.
class Solution:
    def openLock(self, deadends: List[str], target: str) -> int:
        if "0000" in deadends:
            return -1
        if target == "0000":
            return 0
        q = collections.deque(["0000"])
        seen = set(deadends)
        seen.add("0000")
        steps = 0
        while q:
            size = len(q)
            while size:
                size -= 1
                current = q.popleft()
                for i in range(4):
                    for j in [(int(current[i])+1)%10, (int(current[i])-1)%10]:
                        new = current[:i] + str(j) + current[i+1:]
                        if new in seen:
                            continue
                        if new == target:
                            return steps + 1
                        seen.add(new)
                        q.append(new)
            steps += 1
        return -1
