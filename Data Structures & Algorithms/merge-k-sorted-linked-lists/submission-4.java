/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // 1. 결과 리스트를 만들기 위한 dummy 노드
        // 첫 노드 처리의 예외 케이스를 없애기 위해 사용
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        // 2. minHeap. 항상 가장 작은 값을 가진 노드를 먼저 꺼내기 위해 사용
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a, b) -> a.val - b.val
        );

        // 3. 각 리스트의 첫 번째 노드를 힙에 넣음
        // -> k개의 리스트 각각에서 "현재 후보"를 넣는 것
        for (ListNode node : lists) {
            pq.offer(node);
        }

        // 4. 힙이 빌 때까지 반복
        while (!pq.isEmpty()) {
            // 가장 작은 값을 가진 노드를 꺼냄
            ListNode node = pq.poll();
            // 결과 리스트에 연결
            cur.next = node;
            cur = cur.next;

            // 방금 꺼낸 노드의 다음 노드가 있으면 그 리스트의 다음 후보를 힙에 추가
            if (node.next != null) pq.offer(node.next);
        }

        // 5. dummy 다음이 실제 결과의 head
        return dummy.next;
    }
}
