class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int n = nums.length;
        int[] output = new int[n - k + 1];
        int idx = 0;
        
        for (int i = 0; i < n; i++) {
            // 현재 윈도우 범위를 벗어난 인덱스 제거
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            // 현재 값보다 작은 값들은 뒤에서 제거
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            // 현재 인덱스 추가
            deque.offerLast(i);
            if (i >= k - 1) {
                output[idx++] = nums[deque.peekFirst()];
            }
        }
        return output;
    }
}
