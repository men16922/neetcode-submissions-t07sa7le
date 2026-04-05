class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0; // 윈도우 시작 포인터
        int total = 0; // 현재 윈도우 [l ~ r]의 합
        int res = Integer.MAX_VALUE;

        // r을 이동시키면서 윈도우 확장
        for (int r = 0; r < nums.length; r++) {
            total += nums[r]; // 오른쪽 값 추가 -> 합 증가
            // 합이 target 이상이면, 윈도우를 줄이면서 최소 길이 갱신
            while (total >= target) {
                res = Math.min(res, r - l + 1);
                total -= nums[l];
                l++;
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}