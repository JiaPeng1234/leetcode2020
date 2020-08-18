// https://leetcode.com/problems/01-matrix/

/**
By Jiapeng
using BFS + mask
Runtime: 12 ms, faster than 82.98% of Java online submissions for 01 Matrix.
Memory Usage: 43.2 MB, less than 54.39% of Java online submissions for 01 Matrix.
**/
class Solution {
    /**
     step 1: create a full zero "map", all zeros in the map is set to 1
     step 2: use BFS, initialize the queue with all coordinate of zeros
     step 3: zeros begin to diffuse to its non-zero adjacent cells, update them with step 
     step 4: the cells that have already been checked should be added to "map" created in step 1
    **/
    public int[][] updateMatrix(int[][] matrix) {
        int xn = matrix.length; 
        int yn = matrix[0].length;
        if(xn == 0 || yn == 0)
            return matrix;
        
        int[][] map = new int[xn][yn];
        Queue<int[]> deque = new ArrayDeque<>();
        for(int i=0; i<xn; i++)
            for(int j=0; j<yn; j++){
                if(matrix[i][j] == 0){
                    deque.offer(new int[]{i, j});
                    map[i][j] = 1;
                }
            }
        
        // array for traverse adjacent cells
        int[] adjacent = {-1, 0, 1, 0, -1};
        int steps = 0;
        while(!deque.isEmpty()){
            int size = deque.size();
            while(size != 0){
                size--;
                int[] node = deque.poll();
                int row = node[0], col = node[1];
                // up, down, left and right
                for(int i=0; i<4; i++){
                    int x = row + adjacent[i];
                    int y = col + adjacent[i+1];
                    if(x < 0 || y < 0 || x >= xn || y >= yn || map[x][y] == 1)
                        continue;
                    deque.offer(new int[]{x, y});
                    map[x][y] = 1;
                    matrix[x][y] = steps + 1;
                }
            }
            steps++;
        }
        return matrix;
    }
}
