/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        // 결과 리스트 (각 레벨별 노드 값 저장))
        List<List<Integer>> res = new ArrayList<>();
        // 트리가 비어 있으면 빈 리스트 반환
        if (root == null) return res;
        // BFS를 위한 Queue
        Queue<TreeNode> q = new LinkedList<>();
        // 시작 노드 삽입
        q.offer(root);
        
        // Queue가 빌 때까지 반복 (레벨 단위 탐색))
        while (!q.isEmpty()) {
            // 현재 레벨에 있는 노드 개수
            int size = q.size();
            // 현재 레벨 결과를 저장할 리스트
            List<Integer> level = new ArrayList<>();
            // 현재 레벨에 해당하는 노드만 처리
            for (int i = 0; i < size; i++) {
                // Queue에서 하나 꺼냄 (현재 레벨 노드)
                TreeNode node = q.poll();
                // 해당 노드 값을 현재 레벨 리스트에 추가
                level.add(node.val);
                // 왼쪽 자식이 있으면 Queue에 추가 (다음 레벨)
                if (node.left != null) q.offer(node.left);
                // 오른쪽 자식이 있으면 Queue에 추가 (다음 레벨)
                if (node.right != null) q.offer(node.right);
            }
            // 현재 레벨 결과를 전체 결과에 추가
            res.add(level);
        }
        // 모든 레벨 탐색 완료 후 결과 반환
        return res;        
    }
}
