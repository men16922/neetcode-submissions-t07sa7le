class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 1. 각 과목의 진입차수 (선수과목 개수)
        int [] indegree = new int[numCourses];

        // 2. 그래프 (인접 리스트). adj[b] = b를 들으면 갈 수 있는 과목들 (b -> a)
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // 3. 그래프 구성. [a, b] -> b를 먼저 듣고 a를 들을 수 있음
        for (int[] pre : prerequisites) {
            int a = pre[0];
            int b = pre[1];

            adj.get(b).add(a); // b -> a
            indegree[a]++; // a의 선수과목 개수 증가
        }

        // 4. 선수과목이 없는 과목들부터 시작
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) q.add(i);
        }

        // 5. 처리한 과목 수
        int finish = 0;

        // 6. BFS 진행
        while (!q.isEmpty()) {
            int node = q.poll(); // 현재 들을 수 있는 과목
            finish++;

            // 현재 과목을 들으면 갈 수 있는 다음 과목들
            for (int nei : adj.get(node)) {
                indegree[nei]--; // 선수과목 하나 제거

                // 이제 선수과목이 0개면 들을 수 있음
                if (indegree[nei] == 0) q.add(nei);
            }
        }

        // 7. 모든 과목들 들을 수 있으면 true
        return finish == numCourses;
    }
}
