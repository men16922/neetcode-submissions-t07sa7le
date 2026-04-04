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
        // 1. 모든 노드 값을 저장할 리스트
        List<Integer> nodes = new ArrayList<>();
        // 2. 각 Linked list를 순회하면서 값들을 모두 수집
        for (ListNode lst : lists) {
            while (lst != null) {
                nodes.add(lst.val); // 값 추가
                lst = lst.next; // 다음 노드로 이동
            }
        }
        // 3. 수집한 값들을 정렬
        // -> 오름차순으로 만들어서 정렬된 리스트 생성 준비
        Collections.sort(nodes);

        // 4. 결과 linked list를 만들기 위한 dummy 노드
        ListNode res = new ListNode(0);
        ListNode cur = res;

        // 5. 정렬된 값들을 이용해서 새로운 linked list 생성
        for (int node : nodes) {
            cur.next = new ListNode(node); // 새 노드 생성 후 연결
            cur = cur.next;
        }
        // 6. dummy.next가 실제 결과의 head
        return res.next;
    }
}
