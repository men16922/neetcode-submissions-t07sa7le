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
        // 1. init dummy node
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        // 2. init PriorityQueue (minHeap)
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a, b) -> a.val - b.val
        );

        // 3. put each 1st node from lists into pq
        for (ListNode node : lists) {
            pq.offer(node);
        }

        // 4. while pq is empty
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            cur.next = node;
            cur = cur.next;
            if (node.next != null) pq.offer(node.next);
        }
        return dummy.next;
    }
}
