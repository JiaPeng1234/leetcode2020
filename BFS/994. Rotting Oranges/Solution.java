// https://leetcode.com/problems/rotting-oranges/

/**
By Jiapeng
BFS
Runtime: 3 ms, faster than 73.25% of Java online submissions for Rotting Oranges.
Memory Usage: 38.9 MB, less than 86.43% of Java online submissions for Rotting Oranges.
**/
class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        Queue<int[]> q = new ArrayDeque<>();
        for(int i=0; i<grid.length; i++)
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1)
                    fresh++;
                else if(grid[i][j] == 2)
                    q.offer(new int[]{i, j});
            }
        if(fresh == 0)
            return 0;
        
        int[] adjacent = {-1, 0, 1, 0, -1};
        int steps = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size > 0){
                size--;
                int[] node = q.poll();
                int row = node[0], col = node[1];
                for(int i=0; i<4; i++){
                    int x = row + adjacent[i];
                    int y = col + adjacent[i+1];
                    if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] != 1)
                        continue;
                    grid[x][y] = 2;
                    fresh--;
                    q.offer(new int[]{x, y});
                }
                if(fresh == 0)
                    return steps + 1;
            }
            steps++;
        }
        return -1;
    }
}
