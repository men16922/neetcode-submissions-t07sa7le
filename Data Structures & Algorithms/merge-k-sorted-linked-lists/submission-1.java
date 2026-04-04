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
        ListNode dummy =  new ListNode(0);
        ListNode cur = dummy;

        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a, b) -> a.val - b.val
        );
        
        for (ListNode node : lists) {
            if (node != null) pq.offer(node);
        }
    

        while (!pq.isEmpty()) { // 힙이 빌 때까지
            ListNode node = pq.poll();
            cur.next = node;
            cur = cur.next;
            if (node.next != null) pq.offer(node.next);
        }
        return dummy.next;
    }
}
