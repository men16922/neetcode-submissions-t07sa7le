/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        // 1. 입력이 비어있으면 회의실 필요 없음
        if (intervals == null || intervals.size() == 0) return 0;

        // 2. 시작 시간 기준으로 정렬
        // 앞에서부터 회의를 순서대로 처리하기 위해
        intervals.sort((a, b) -> Integer.compare(a.start, b.start));

        // 3. 현재 사용 중인 회의실들의 종료 시간을 저장하는 최소 힙
        // -> 가장 빨리 끝나는 회의를 빠르게 확인하기 위해
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // 4. 첫 번째 회의는 무조건 방 하나 필요
        minHeap.offer(intervals.get(0).end);

        // 5. 두 번째 회의부터 순차적으로 확인
        for (int i = 1; i < intervals.size(); i++) {
            int start = intervals.get(i).start;
            int end = intervals.get(i).end;
            
            // 6. 가장 빨리 끝나는 회의가 현재 회의 시작 전에 끝났으면
            // -> 기존 회의실 재사용 가능
            if (start >= minHeap.peek()) minHeap.poll();

            // 7. 현재 회의를 배정 (새 방이든 재사용이든 종료 시간 추가)
            minHeap.offer(end);
        }
        return minHeap.size();
    }
}
