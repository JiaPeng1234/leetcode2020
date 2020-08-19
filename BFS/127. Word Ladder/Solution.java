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
Runtime: 17 ms, faster than 95.65% of Java online submissions for Word Ladder.
Memory Usage: 39.9 MB, less than 95.29% of Java online submissions for Word Ladder.
**/
class Solution2 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>();
        for(String word: wordList){
            dict.add(word);
        }
        if(!dict.contains(endWord))
            return 0;
        dict.remove(endWord);
        
        Set<String> s1 = new HashSet<>(), s2 = new HashSet<>();
        s1.add(beginWord);
        s2.add(endWord);
        int steps = 0;
        
        while(s1.size() > 0 && s2.size() > 0){
            if(s1.size() > s2.size()){
                Set<String> tmp = s1;
                s1 = s2;
                s2 = tmp;
            }
            
            Set<String> s = new HashSet<>();
            for(String current_word: s1){   // not able to use while-loop here, cause there is no methode like pop() for HaseSet, HashSet is disordered
                char[] letters = current_word.toCharArray();    // turn String into char[] array
                for(int i=0; i<letters.length; i++){
                    char tmp = letters[i];  // similar to backtracking
                    for(char c='a'; c<='z'; c++){
                        letters[i] = c;
                        String new_word = new String(letters);
                        if(s2.contains(new_word))
                            return steps + 2;
                        if(dict.contains(new_word)){
                            s.add(new_word);
                            dict.remove(new_word);
                        }
                    }
                    letters[i] = tmp;   // similar to backtracking
                }
            }
            s1 = s;
            steps++;
        }
        return 0;
    }
}
