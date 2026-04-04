class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];

        // 색이 이미 같으면 변화 필요 없음
        if (originalColor == color) return image;

        int m = image.length;
        int n = image[0].length;

        // BFS에서 사용할 큐
        Queue<int []> q = new LinkedList<>();
        q.add(new int [] {sr, sc});

        // 시작 픽셀의 색을 먼저 바꿔줌
        image[sr][sc] = color;

        // 네 방향 이동을 위한 좌표 배열
        int [][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!q.isEmpty()) {
            int [] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            // 네 방향으로 탐색
            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                // 범위 안이고, originalColor이면 큐에 추가
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && image[nr][nc] == originalColor) {
                    // 색 변경
                    image[nr][nc] = color;
                    q.add(new int[] {nr, nc});
                }
            }
        }
        return image;
    }
}