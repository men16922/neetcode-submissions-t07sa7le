class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        // 1. 시작 시간(index 0) 기준으로 오름차순 정렬
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> merged = new ArrayList<>();

        // 2. 첫 번째 구간을 기준으로 시작
        int[] current = intervals[0];
        merged.add(current);

        for (int[] next : intervals) {
            int currentEnd = current[1];
            int nextStart = next[0];
            int nextEnd = next[1];

            // 3. 현재 구간의 끝이 다음 구간의 시작보다 크거나 같으면 겹침
            if (currentEnd >= nextStart) {
                // 병합: 끝점을 더 큰 값으로 갱신
                current[1] = Math.max(currentEnd, nextEnd);
            } else {
                // 겹치지 않으면 새로운 구간을 결과에 추가하고 기준 변경
                current = next;
                merged.add(current);
            }
        }
        // 4. List를 int[][] 배열로 변환
        return merged.toArray(new int[merged.size()][]);
    }
}
