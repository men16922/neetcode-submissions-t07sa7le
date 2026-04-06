class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        // 결과를 저장할 배열
        // output[i] = nums[i]를 제외한 모든 원소의 곱
        int[] output = new int[n];

        // 모든 값을 1로 초기화
        Arrays.fill(output, 1);

        // prefix product (왼쪽 누적 곱)
        // prefix는 현재 인덱스 i의 왼쪽에 있는 모든 숫자의 곱
        int prefix = 1;
        for (int i = 0; i < n; i++) {
            // i 기준 왼쪽 곱을 output에 저장
            output[i] = prefix;
            // 다음 인덱스를 위해 nums[i]를 누적
            prefix *= nums[i];
        }

        // 3. suffix product (오른쪽 누적 곱)
        // sufix는 현재 인덱스 i의 오른쪽에 있는 모든 숫자의 곱
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            // 기존 왼쪽 곱 x 오른쪽 곱
            output[i] *= suffix;
            // 다음 인덱스를 위해 nums[i]를 누적
            suffix *= nums[i];
        }
        return output;
    }
}  
