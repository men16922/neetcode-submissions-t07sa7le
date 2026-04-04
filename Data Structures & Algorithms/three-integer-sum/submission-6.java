class Solution {
    /**
        정렬한다.
        i는 전체를 돌며 첫 숫자 선택.
        l = i+1, r = 끝에서 시작.
        sum<0 → l++
        sum>0 → r--
        sum==0 → 저장 + 중복 제거 + l++, r--
    **/
    public List<List<Integer>> threeSum(int[] nums) {
        // 정렬
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            if (nums[i] > 0) break;

            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    l++;
                    r--;
                } else if (sum < 0) l++;
                else r--;
            }
        }
        return res;
    }
}
