class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> qq = new ArrayDeque<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    qq.offer(new int[] {i, j});
                }
            }
        }

        final int ROW = grid.length;
        final int COL = grid[0].length;
        final int dirs[][] = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        while (!qq.isEmpty()) {
            int curr[] = qq.poll();
            int r = curr[0];
            int c = curr[1];

            for(int dir[]: dirs){
                int nr = r + dir[0];
                int nc = c + dir[1];

                if(nc < 0 || nr < 0 || nr >= ROW || nc >= COL || grid[nr][nc] != Integer.MAX_VALUE){
                    continue;
                }

                grid[nr][nc] = grid[r][c] + 1;
                qq.offer(new int[]{nr, nc});
            }
        }
    }
}
