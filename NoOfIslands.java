/*
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
*/
class Solution {
    public int numIslands(char[][] grid) {
        int count=0;
        int m=grid.length, n=grid[0].length;
        boolean vis[][]=new boolean[m][n];
        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++)
            {
                if(!vis[i][j] && grid[i][j]=='1'){
                    count++;
                    dfs(grid, vis, i, j);
                }
            }
        return count;
    }
    void dfs(char[][] grid, boolean[][] vis, int i, int j)
    {
        vis[i][j]=true;
        if(i+1<grid.length && !vis[i+1][j] && grid[i+1][j]=='1')dfs(grid, vis, i+1, j);
        if(i-1>=0 && !vis[i-1][j] && grid[i-1][j]=='1')dfs(grid, vis, i-1, j);
        if(j+1<grid[0].length &&!vis[i][j+1] && grid[i][j+1]=='1')dfs(grid, vis, i, j+1);
        if(j-1>=0 && !vis[i][j-1] && grid[i][j-1]=='1')dfs(grid, vis, i, j-1);
    }
}
