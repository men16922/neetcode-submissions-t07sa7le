class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int [] res = new int[n];
        // 아직 더 따듯한 날을 못 찾은 날짜의 index 저장
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            // 현재 온도가 스택 top 날짜보다 더 따뜻하면
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevDay = stack.pop();
                res[prevDay] = i - prevDay;
            }

            // 현재 날짜를 대기 목록에 추가
            stack.push(i);
        }
        return res;
    }
}
