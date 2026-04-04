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
    /**
        문제 정의:
            각각의 리스트가 정렬되어 있다. 병합해서 하나의 리스트로 만들어라 (ASC ORDER)
        
        접근 방법:
            PriorityQueue - MinHeap을 쓰는게 좋을 것 같음
            각 리스트에서 가장 앞의 노드들을 큐에 담고 (가장 작은 값), 계속 이어 붙인다.
            노드의 next를 큐에 넣으면서 다음 최소값을 찾는다.

        시간복잡도:
            PriroityQueue가 O(logN)임. 리스트 개수가 K
        공간복잡도:
            O(K)
    */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a, b) -> a.val - b.val
        );

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        for (ListNode node : lists) {
            if (node != null) pq.add(node); // 각 리스트의 첫 번쨰 노드를 집어넣는다.
        }

        // Loop
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            cur.next = node; // 결과 리스트에 연결
            cur = cur.next;
            if (node.next != null) pq.add(node.next);
        }

        return dummy.next; // 시작 노드 반환
    }
}
