class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //1. Array sort
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            // i + 1 = i 인 경우, 뒤의 숫자들도 동일하기에 skip
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            // 조기 종료 (정렬됐으므로 이후도 양수)
            if (nums[i] > 0) break;

            int l = i + 1;
            int r = nums.length - 1;
            
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    // l 중복 스킵
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    l++;
                    r--;
                } else if (sum < 0) l++;
                else r--;
            }
        }
        return result;
    }
}
