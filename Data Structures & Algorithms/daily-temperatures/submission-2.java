class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            int count = 1; // i 번째에서 며칠 뒤인지 의미
            int j = i + 1; // 다음 날부터 확인
            while (j < n) {
                if (temperatures[j] > temperatures[i]) break;
                // 더 따뜻하지 않으면 다음 날로 이동
                j++;
                // 하루 더 지나면 날짜 차이 + 1
                count++;
            }

            // 끝까지 갔는데 더 따뜻한 날이 없으면 0
            count = (j == n) ? 0 : count;
            // i 번쨰 날의 정답 -> i일부터 count일 뒤에 더 따듯한 날이 옴
            res[i] = count;
        }
        return res;
    }
}
