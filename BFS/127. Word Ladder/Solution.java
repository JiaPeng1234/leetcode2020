// https://leetcode.com/problems/word-ladder/

/**
By Jiapeng
using normal BFS & BASIC BFS Framework
Runtime: 50 ms, faster than 81.19% of Java online submissions for Word Ladder.
Memory Usage: 41.3 MB, less than 75.02% of Java online submissions for Word Ladder.
**/
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>();
        for(String word: wordList) dict.add(word);
        if(!dict.contains(endWord)) return 0;
        
        Queue<String> q = new ArrayDeque<>();
        q.offer(beginWord);
        
        int steps = 0;
        
        while(!q.isEmpty()){
            int size = q.size();
            while(size > 0){
                size--;
                String current_word = q.poll();
                
                if(current_word.equals(endWord))
                    return steps + 1;
                
                char[] chs = current_word.toCharArray();
                for(int i=0; i<chs.length; i++){
                    char tmp = chs[i];
                    for(char j='a'; j<='z';j++){
                        if(j == tmp) continue;
                        chs[i] = j;
                        String t = new String(chs);
                        if(!dict.contains(t)) continue;
                        q.offer(t);
                        dict.remove(t);
                    }          
                    chs[i] = tmp;
                }
            }
            steps++;
        }
        return 0;
    }
}

/**
By Jiapeng
using bidirectional BFS & BASIC BFS Framework, advanced performance achieved

**/
