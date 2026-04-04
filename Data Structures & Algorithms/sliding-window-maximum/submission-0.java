class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        // 결과 배열 (윈도우 개수 = n - k + 1)
        int[] output = new int[n - k + 1];
        // i = 각 윈도우의 시작 위치
        for (int i = 0; i < n - k + 1; i++) {
            // 현재 윈도우의 최대값 (처음 값으로 초기화)
            int maxi = nums[i];
            // 현재 윈도우 범위: i ~ i + k - 1
            for (int j = i; j < i + k; j++) {
                // 윈도우 안에서 최대값 계속 갱신
                maxi = Math.max(maxi, nums[j]);
            }
            // 해당 윈도우의 최대값 저장
            output[i] = maxi;
        }
        // 모든 윈도우 결과 반환
        return output;
    }
}
