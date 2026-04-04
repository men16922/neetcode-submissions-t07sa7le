class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // deque에는 인덱스 저장
        // 이유 : 범위 체크 (i -k)
        Deque<Integer> deque = new ArrayDeque<>();
        int n = nums.length;
        int[] output = new int[n - k + 1];
        int idx = 0;
        
        for (int i = 0; i < n; i++) {
            // 현재 윈도우 범위를 벗어난 인덱스 제거
            // 현재 윈도우 [i - k + 1 ~ i]. i - k 이하이면 윈도우 밖
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            // 현재 값보다 작은 값들은 뒤에서 제거
            // nums[i] 기 더 크면 뒤의 있는 값들은 max 불가
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            // 현재 인덱스 추가
            deque.offerLast(i);

            // 윈도우가 완성되었을 때 (i >= k - 1)
            if (i >= k - 1) {
                // deque의 맨 앞은 항상 최대값의 인덱스
                output[idx++] = nums[deque.peekFirst()];
            }
        }
        return output;
    }
}
