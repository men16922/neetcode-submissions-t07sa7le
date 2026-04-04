class Solution {
    public int[][] merge(int[][] intervals) {
        // 1. 구간을 시작점 기준으로 정렬
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        // 2. 병합된 결과를 저장할 리스트
        List<int[]> merged = new ArrayList<>();
        // 3. 정렬된 구간을 하나씩 확인
        for (int[] interval : intervals) {
            // 결과가 비어있거나, 이전 구간과 겹치지 않으면 그대로 추가
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(interval);
            } else {
                // 겹치면 끝점을 더 큰 값으로 갱신해서 병합
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
            }
        }

        // 4. List<int[]>를 int[][]로 변환해서 반환
        return merged.toArray(new int[merged.size()][]);
    }
}
