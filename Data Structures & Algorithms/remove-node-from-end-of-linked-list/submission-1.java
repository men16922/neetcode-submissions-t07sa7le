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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode slow = dummy;
        ListNode fast = dummy;

        // 1. gap 만들기
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // 2. 같이 이동
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // 3. 삭제
        slow.next = slow.next.next;
        return dummy.next;
    }
}
