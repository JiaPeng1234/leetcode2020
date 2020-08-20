// https://leetcode.com/problems/open-the-lock/

/**
By Jiapeng
BFS
Runtime: 51 ms, faster than 94.55% of Java online submissions for Open the Lock.
Memory Usage: 41.4 MB, less than 90.90% of Java online submissions for Open the Lock.
**/
class Solution {
    public int openLock(String[] deadends, String target) {
        if(target.equals("0000"))   // 我们的出口条件在BFS当前节点的下一层判断，因此先把本层的出口条件判断好很必要
            return 0;
        Set<String> seen = new HashSet<>();
        for(String deadend: deadends){
            if(deadend.equals("0000"))   // 我们的break条件在BFS当前节点的下一层判断，因此先把本层的break条件判断好很必要
                return -1;
            seen.add(deadend);
        }
        
        Queue<String> q = new ArrayDeque<>();
        q.offer("0000");
        
        int steps = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size > 0){
                size--;
                String current = q.poll();
                char[] chs = current.toCharArray();
                for(int i=0; i<4; i++){
                    char tmp = chs[i];      // 注意此处很绕，要还原原有的chs的模样
                    for(int j=-1; j<=1; j+=2){
                        chs[i] = (char)(((tmp - '0') + j + 10) % 10 + '0');     // 注意此处要用tmp而不是用chs[i]
                        String newnum = new String(chs);
                        if(newnum.equals(target))
                            return steps + 1;
                        if(seen.contains(newnum))
                            continue;
                        seen.add(newnum);
                        q.offer(newnum);
                    }
                    chs[i] = tmp;       // 还原原有的chs的模样
                }
            }
            steps++;
        }
        return -1;
    }
}
