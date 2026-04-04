class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];
        // 만약 시작 픽셀의 색이 이미 목표 색이면 아무것도 할 필요 없음
        if (originalColor == color) return image;
        // DFS 시작
        dfs(image, sr, sc, originalColor, color);
        return image;
    }

    private void dfs(int[][] image, int r, int c, int originalColor, int newColor) {
        // 범위를 벗어나면 return
        if (r < 0 || c < 0 || r >= image.length || c >= image[0].length) return;

        // originalColor가 아니면 색을 바꾸지 않음
        if (image[r][c] != originalColor) return;

        // 색을 변경
        image[r][c] = newColor;

        // 네 방향으로 DFS 확장
        dfs(image, r + 1, c, originalColor, newColor); // 아래
        dfs(image, r - 1, c, originalColor, newColor); // 위
        dfs(image, r, c + 1, originalColor, newColor); // 오른쪽
        dfs(image, r, c - 1, originalColor, newColor); // 왼쪽

    }
}