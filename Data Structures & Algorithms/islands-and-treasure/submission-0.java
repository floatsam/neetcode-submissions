class Solution {
    public void islandsAndTreasure(int[][] grid) {
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0){
                    dfs(grid, i, j, 0);
                }
            }
        }
    }
    private void dfs(int[][] grid, int x, int y, int localMax){
        int ROW = grid.length;
        int COL = grid[0].length;
        if(x < 0 || y < 0 || x >= ROW || y >= COL || grid[x][y] == -1 || (grid[x][y] <= localMax && localMax > 0)){
            return;
        }
        if(grid[x][y] != 0){
            grid[x][y] = Math.min(grid[x][y], localMax);
        }
        
        dfs(grid, x + 1, y, localMax + 1);
        dfs(grid, x - 1, y, localMax + 1);
        dfs(grid, x, y - 1, localMax + 1);
        dfs(grid, x, y + 1, localMax + 1);
    }
}