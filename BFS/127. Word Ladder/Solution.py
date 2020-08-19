# https://leetcode.com/problems/word-ladder/

# By Jiapeng
# BFS
# Runtime: 116 ms, faster than 91.40% of Python3 online submissions for Word Ladder.
# Memory Usage: 17.1 MB, less than 53.45% of Python3 online submissions for Word Ladder.
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        if endWord not in wordList:
            return 0
        mapp = defaultdict(list)
        for word in wordList:
            for i in range(len(word)):
                mapp[word[:i]+'*'+word[i+1:]].append(word)
        seen = set(beginWord)   # important: if not using set but a normal list, Runtime would be 30 times slower
                                # generally speaking, searching efficiency: set > hashmap > list
        q = []
        q.append(beginWord)
        steps = 0
        while q:
            size = len(q)
            while size:
                size -= 1
                state = q.pop(0)
                if state == endWord:
                    return steps+1
                for i in range(len(state)):
                    for new_state in mapp[state[:i]+'*'+state[i+1:]]:
                        if new_state not in seen:
                            seen.add(new_state)
                            q.append(new_state)
            steps += 1
        return 0

# By Jiapeng
# Bidirectional BFS, can still be optimized (by turning wordList to map which is already done in Solution1)
# Compared with normal BFS, bidirectional BFS saves huge amount of time in large data scale
# Runtime: 104 ms, faster than 94.11% of Python3 online submissions for Word Ladder.
# Memory Usage: 14.8 MB, less than 75.50% of Python3 online submissions for Word Ladder.
