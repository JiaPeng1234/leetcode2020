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
# Bidirectional BFS, bad example: using deque but not set, waste plenty of time searching in queue
# Runtime: 116 ms, faster than 91.40% of Python3 online submissions for Word Ladder.
# Memory Usage: 17.1 MB, less than 53.45% of Python3 online submissions for Word Ladder.
class Solution2:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        """
        Bedirectional BFS
        create two queue, one for beginWord, one for endWord
        BFS search from both queue
        search the queue with smaller size first
        if the word currently being checked is contained by the other queue, we find the answer
        """
        wordList = set(wordList)
        if endWord not in wordList:
            return 0
        wordList.remove(endWord)
        q1, q2 = collections.deque([beginWord]), collections.deque([endWord])
        steps = 0
        while(q1 and q2):
            if len(q1) > len(q2):
                q1, q2 = q2, q1
            size = len(q1)
            while size:
                size -= 1
                current_word = q1.popleft()
                for i in range(len(current_word)):
                    for c in string.ascii_lowercase: 
                        new_word = current_word[:i] + c + current_word[i+1:]
                        if new_word in q2:      # here, plenty of time wasted, when searching use set or hashmap instead of list or queue
                            return steps + 2
                        if new_word in wordList:
                            wordList.remove(new_word)
                            q1.append(new_word)
            steps += 1
        return 0
    
# By Jiapeng
# Bidirectional BFS, can still be optimized (by turning wordList to map which is already done in Solution1)
# Compared with normal BFS, bidirectional BFS saves huge amount of time in large data scale
# Runtime: 104 ms, faster than 94.11% of Python3 online submissions for Word Ladder.
# Memory Usage: 14.8 MB, less than 75.50% of Python3 online submissions for Word Ladder.
class Solution3:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        """
        Bedirectional BFS
        create two queue, one for beginWord, one for endWord
        BFS search from both queue
        search the queue with smaller size first
        if the word currently being checked is contained by the other queue, we find the answer
        """
        wordList = set(wordList)
        if endWord not in wordList:
            return 0
        wordList.remove(endWord)
        q1, q2 = {beginWord}, {endWord}
        steps = 0
        while(q1 and q2):
            if len(q1) > len(q2):
                q1, q2 = q2, q1
            size = len(q1)
            tmp = set()     # create a new set for q1's children, cause in set we can't pop the head element everytime, set is disordered
                            # another reason why we need a new set: it's not good to change set itself when we traverse it
                            # especially when we use for-loop (we used while-loop in this problem)
            while size:
                size -= 1
                current_word = q1.pop()     # attention: pop() for set means pop a random element of it
                for i in range(len(current_word)):
                    for c in string.ascii_lowercase: 
                        new_word = current_word[:i] + c + current_word[i+1:]
                        if new_word in q2:
                            return steps + 2    # BFS from two sides, need to add 2 here
                        if new_word in wordList:
                            wordList.remove(new_word)
                            tmp.add(new_word)
            q1 = tmp    # switch q1 with tmp
            steps += 1
        return 0
