class Solution {
    private int [][] grid; // 입력 grid 저장
    private boolean [][] visited; // 방문 여부 체크 (중복 탐색 방지)
    private int rows, cols; // grid 크기

    public int islandPerimeter(int[][] grid) {
        this.grid = grid;
        this.rows = grid.length;
        this.cols = grid[0].length;
        this.visited = new boolean[rows][cols];

        // 1. 섬의 시작점 (land = 1) 찾기
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // 2. 첫 land 발견 -> DFS 시작
                if (grid[i][j] == 1) return dfs(i, j);
            }
        }
        return 0;
    }

    private int dfs(int i, int j) {
        // 3. 범위를 벗어나거나 물(0)을 만나면 -> 둘레 1 증가
        if (i < 0 || j < 0 || i >= rows || j >= cols || grid[i][j] == 0) return 1;
        // 4. 이미 방문한 land면 -> 이미 계산했으므로 0 반환
        if (visited[i][j]) return 0;
        // 5. 현재 land 방문 처리
        visited[i][j] = true;
        // 6. 4방향 탐색. 각각의 방향에서 둘레를 계산해서 더함
        return dfs(i, j + 1) // 오른쪽
             + dfs(i + 1, j) // 아래
             + dfs(i, j - 1) // 왼쪽
             + dfs(i - 1, j); // 위
    }
}