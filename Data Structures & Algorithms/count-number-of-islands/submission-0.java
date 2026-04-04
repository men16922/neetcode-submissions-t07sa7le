class Solution {
    public int numIslands(char[][] grid) {
        int count = 0; // 섬 개수

        // 전체 Grid 순회
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // 1을 발견하면 -> 새로운 섬
                if (grid[i][j] == '1') count++; // 섬 개수 증가
                // 이 섬을 전부 제거 (DFS로 퍼지면서 0으로 바꿈)
                dfs(grid, i, j);
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        // 1. 범위 벗어나면 종료
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) return;
        // 2. 물(0)이면 더 이상 갈 필요 없음
        if (grid[i][j] == '0') return;
        // 3. 현재 위치 방문 처리 -> 다시 방문하지 않도록 1을 0으로 바꿈
        grid[i][j] = '0';
        // 4. 4방향으로 퍼지기 (DFS)
        dfs(grid, i + 1, j); // 아래
        dfs(grid, i - 1, j); // 위
        dfs(grid, i, j + 1); // 오른쪽
        dfs(grid, i, j - 1); // 왼쪽
    }
}
