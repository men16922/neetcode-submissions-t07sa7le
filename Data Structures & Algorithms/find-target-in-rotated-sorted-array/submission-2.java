class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        // standard binary search loop
        while (l <= r) {
            int mid = l + (r - l) / 2;
            // target 찾은 경우 바로 반환
            if (nums[mid] == target) return mid;
            // 왼쪽 구간 [l + mid]이 정렬된 경우
            if (nums[l] <= nums[mid]) {
                // target이 왼쪽 정렬 구간에 없는 경우
                // (mid보다 크거나, l보다 작은 경우)
                if (target > nums[mid] || target < nums[l]) l = mid + 1;// 오른쪽 탐색
                else r = mid - 1; // 왼쪽 탐색
            } else {
                // 오른쪽 구간 [mid - r] 이 정렬된 경우

                // target이 오른쪽 정렬 구간에 없는 경우
                // (mid보다 작거나, r보다 큰 경우)
                if (target < nums[mid] || target > nums[r]) r = mid - 1;
                else l = mid + 1;
            }
        }

        // 끝까지 못 찾으면 -1
        return -1;
    }
}
