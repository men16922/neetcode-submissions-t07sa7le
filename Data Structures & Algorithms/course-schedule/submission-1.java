class Solution {
    // 각 과목 -> 선수과목 리스트
    private Map<Integer, List<Integer>> preMap = new HashMap<>();
    // 현재 DFS 경로에 있는 과목들
    private Set<Integer> visiting = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 1. 모든 과목에 대해 빈 리스트 초기화
        for (int i = 0; i < numCourses; i++) {
            preMap.put(i, new ArrayList<>());
        }
        // 2. 그래프 구성. [a, b] => a를 들으려면 b 필요
        for (int[] prereq : prerequisites) {
            preMap.get(prereq[0]).add(prereq[1]);
        }
        // 3. 모든 과목에 대해 DFS 수행
        for (int c = 0; c < numCourses; c++) {
            if (!dfs(c)) return false; // 사이클 발견 시 종료
        }
        return true; // 모든 과목 가능
    }

    private boolean dfs(int crs) {
        // 1. 현재 경로에서 다시 등장 -> 사이클 존재
        if (visiting.contains(crs)) return false;
        // 2. 선수과목이 없음 -> 더 볼 필요 없음 (이미 안전)
        if (preMap.get(crs).isEmpty()) return true;
        // 3. 현재 과목을 DFS 경로에 추가
        visiting.add(crs);
        // 4. 선수과목들을 하나씩 DFS로 확인
        for (int pre : preMap.get(crs)) {
            if (!dfs(pre)) return false; // 하나라도 사이클이면 실패
        }
        // 5. DFS 경로에서 제거 (다른 경로 탐색을 위해)
        visiting.remove(crs);
        // 6. 메모이제이션 (이미 안전한 노드로 처리), 다음에 다시 방문하면 바로 true 반환
        preMap.put(crs, new ArrayList<>());
        return true;
    }
}
