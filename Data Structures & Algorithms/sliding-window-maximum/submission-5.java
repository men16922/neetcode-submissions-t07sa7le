class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int n = nums.length;
        int[] output = new int[n - k + 1];
        int idx = 0;

        for (int i = 0; i < n; i++) {
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);

            if (i >= k - 1) {
                output[idx++] = nums[deque.peekFirst()];
            }
        }
        return output;
    }
}
