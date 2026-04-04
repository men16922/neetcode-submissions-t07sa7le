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
    /*
        문제 정의
        시작 시간, 끝 시간 있는 객체 배열
        겹치지 않게 모든 미팅을 잡으려면 방이 몇개 필요한지?
        0,8 -> 8,10처럼 끝나는 시간이랑 시작 시간이 겹쳐도 된다

        접근 방법
        - 미팅들을 시작 시간 순으로 정렬을 한다. 그래야 회의실이 언제 새로 필요한지 알 수 있다.
        그리고 사용 중인 회의실을 바로 찾으려면, MinHeap(PriorityQueue)를 쓰면 될 것 같다.
        
        시간복잡도
        - 정렬 : O(nlogN)
        - PriorityQueue : O(nlogN)


    */
    public int minMeetingRooms(List<Interval> intervals) {
        // 파라미터를 체크
        if (intervals == null || intervals.size() == 0) return 0;
        // 정렬. 시작시간 순
        intervals.sort((a, b) -> Integer.compare(a.start, b.start));
        // Queue 선언
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(intervals.get(0).end); // 첫번째 회의는 끝나는 시간을 봐야함. 시작시간은 필요 X

        // Loop - 1번째부터.
        for (int i = 1; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            int earlistend = pq.peek();
            if (cur.start >= earlistend) {
                pq.poll();
            }
            pq.offer(cur.end);
        }
        return pq.size();
    } 
}
