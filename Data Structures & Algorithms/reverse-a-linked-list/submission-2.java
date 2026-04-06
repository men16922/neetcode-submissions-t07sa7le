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
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode temp = cur.next; // temp = 1, temp = 2
            cur.next = prev; // cur.next = null, cur.next = 0
            prev = cur; // prev = 0, prev = 1
            cur = temp; // cur = 1, cur = 2
        }
        return prev;
    }
}
