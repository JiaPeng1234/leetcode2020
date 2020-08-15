// https://leetcode.com/problems/word-search/

/**
By Jiapeng
Runtime: 4 ms, faster than 99.25% of Java online submissions for Word Search.
Memory Usage: 41.4 MB, less than 79.88% of Java online submissions for Word Search.
**/

class Solution {
    public boolean exist(char[][] board, String word) {
        int xn = board.length;
        int yn = board[0].length;
        for(int x=0; x<xn; x++){
            for(int y=0; y<yn; y++){
                if(dfs(0, x, y, board, word))
                    return true;
            }
        }
        return false;
    }
    
    private boolean dfs(int d, int x, int y, char[][] board, String word){
        if(d == word.length())
            return true;
        if(x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] != word.charAt(d))
            return false;
        
        char tmp = board[x][y];
        board[x][y] = '0';
        boolean flag = dfs(d+1, x, y+1, board, word) ||
            dfs(d+1, x, y-1, board, word) ||
            dfs(d+1, x+1, y, board, word) ||
            dfs(d+1, x-1, y, board, word);
        board[x][y] = tmp;
        return flag;
    }
}
