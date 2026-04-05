class Solution {
    public int findCircleNum(int[][] isConnected) {
        // 도시 개수
        // isConnected는 n x n 행렬이므로 행의 길이가 곧 도시 수
        int n = isConnected.length;

        // visited[i] = true 이면 i번 도시는 이미 어떤 province 탐색 중에 방문한 상태
        // 중복 방문을 막기 위해 필요
        boolean[] visited = new boolean[n];
        

        // 총 province(연결된 도시 그룹) 개수
        int count = 0;

        // 모든 도시를 하나씩 확인
        for (int i = 0; i < n; i++) {
            // 아직 방문하지 않은 도시라면
            // 이 도시는 지금까지 발견한 어떤 province에도 속하지 않았다는 뜻
            if (!visited[i]) {
                // i번 도시에서 시작해서 연결된 모든 도시를 DFS로 방문 처리
                // 한 번의 DFS = 하나의 province 전체를 탐색
                dfs(isConnected, visited, i);

                // DFS를 한 번 시작했다는 것은 새로운 province를 하나 발견했다는 의미
                count++;
            }
        }
        
        // 전체 province 개수 반환
        return count;
    }

    public void dfs(int[][] graph, boolean[] visited, int city) {
        // 현재 도시를 방문 처리
        // 이 처리를 먼저 해줘야 사이클처럼 다시 돌아와도 무한 재귀에 빠지지 않음
        visited[city] = true;
        // 현재 city와 연결된 모든 도시를 확인
        // graph[city][j] == 1 이면 city와 j가 직접 연결되어 있다는 뜻
        for (int j = 0; j < graph.length; j++) {
            // 연결되어 있고, 아직 방문하지 않은 도시라면
            // 그 도시도 같은 province에 속하므로 계속 탐색
            if (graph[city][j] == 1 && !visited[j]) {
                dfs(graph, visited, j);
            }
        }
    }
}