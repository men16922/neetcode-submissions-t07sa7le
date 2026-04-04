class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1') { // 새로운 섬 발견
                    count++;
                    dfs(grid, r, c);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int r, int c) {
        if (r < 0 || r >= grid.length) return;
        if (c < 0 || c >= grid[0].length) return;
        if (grid[r][c] == '0') return;
        grid[r][c] = '0'; // 방문 처리 (침수)
        dfs(grid, r + 1, c); // 하
        dfs(grid, r - 1, c); // 상
        dfs(grid, r, c + 1); // 우
        dfs(grid, r, c - 1); // 좌

    }
}
