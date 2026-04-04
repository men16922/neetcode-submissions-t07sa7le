class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int islands = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1') { // 새로운 섬 발견
                    islands++;
                    dfs(grid, r, c);
                }
            }
        }
        return islands;
    }

    private void dfs(char[][] grid, int r, int c) {
        int rows = grid.length;
        int cols = grid[0].length;

        // 1. 범위 + 물 확인
        if (r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] == '0') return;
        // 방문 처리
        grid[r][c] = '0';

        // 4방향 탐색
        dfs(grid, r + 1, c); // 아래
        dfs(grid, r - 1, c); // 위
        dfs(grid, r, c + 1); // 오른쪽
        dfs(grid, r, c - 1); // 왼쪽
    }
}
