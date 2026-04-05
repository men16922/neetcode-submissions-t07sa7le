class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(isConnected, visited, i);
                count++;
            }
        }
        return count;
    }

    private void bfs(int[][] graph, boolean[] visited, int start) {
        Queue<Integer> q = new LinkedList<>();
        // 시작 도시 넣고 방문 처리
        q.add(start);
        visited[start] = true;

        // 큐가 빌 때까지 반복
        while (!q.isEmpty()) {
            int city = q.poll();
            // 현재 도시와 연결된 모든 도시 확인
            for (int j = 0; j < graph.length; j++) {
                // 연결되어 있고 아직 방문 안 했으면
                if (graph[city][j] == 1 && !visited[j]) {
                    visited[j] = true; // 방문 처리
                    q.add(j); // 다음 탐색 대상으로 추가
                }
            }
        }
    }
}