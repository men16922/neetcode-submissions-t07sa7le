class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // 1. 그래프 생성
        // graph[u] = {v, w} 목록
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];
            graph.get(u).add(new int[]{v, w});
        }

        // 2. 시작점 k에서 각 노드까지의 최단 거리 저장
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        // 3. 최소 힙. [현재까지 걸린 시간, 현재 노드]
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );
        pq.offer(new int[]{0, k});

        // 4. 다익스트라 알고리즘
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curTime = cur[0];
            int node = cur[1];

            // 이미 더 짧은 경로가 있으면 무시
            if (curTime > dist[node]) continue;

            // 현재 노드에서 갈 수 있는 이웃 노드들 확인
            for (int[] neighbor : graph.get(node)) {
                int next = neighbor[0];
                int weight = neighbor[1];
                int newTime = curTime + weight;

                // 더 짧은 경로를 찾았으면 갱신
                if (newTime < dist[next]) {
                    dist[next] = newTime;
                    pq.offer(new int[]{newTime, next});
                }
            }
        }

        // 5. 모든 노드 중 가장 오래 걸린 시간을 찾음
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            // 도달 못한 노드가 있으면 실패
            if (dist[i] == Integer.MAX_VALUE) return -1;
            answer = Math.max(answer, dist[i]);
        }
        return answer;
    }
}
