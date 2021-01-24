class Solution {
    public int numIslands(char[][] grid) {
        if(grid.length==0 || grid[0].length==0)
            return 0;
        int ans = 0;
        for(int i=0; i<grid.length; i++)
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]=='1'){
                    dfs(i, j, grid);
                    ans++;
                }
            }
        return ans;
    }
    
    private void dfs(int x, int y, char[][] grid){
        if(x<grid.length && y<grid[0].length && x>=0 && y>=0 && grid[x][y]=='1'){
            grid[x][y] = '0';
            dfs(x+1, y, grid);
            dfs(x, y+1, grid);
            dfs(x-1, y, grid);
            dfs(x, y-1, grid);
            
        }
    }
}
