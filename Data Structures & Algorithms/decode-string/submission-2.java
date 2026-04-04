class Solution {
    public String decodeString(String s) {
        // 반복횟수 스택
        Stack<Integer> countStack = new Stack<>();
        // 문자열 스택 (이전 상태 저장)
        Stack<StringBuilder> strStack = new Stack<>();

        StringBuilder cur = new StringBuilder(); // 현재 문자열
        int num = 0; // 현재 숫자 (반복 횟수)

        for (char c : s.toCharArray()) {
            // 숫자면 반복횟수 계산 (여러 자리 가능 12[ab])
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }

            // 여는 괄호: 현재 상태 저장 & 새 문자열 시작
            else if (c == '[') {
                countStack.push(num); // 반복 횟수 저장
                strStack.push(cur); // 이전 문자열 저장
                cur = new StringBuilder(); // 새 문자열 저장
                num = 0; // 숫자 초기화
            }

            // 닫는 괄호 : 반복해서 이전 문자열과 합침
            else if (c == ']') {
                int repeate = countStack.pop();
                StringBuilder prev = strStack.pop();
                // cur 문자열을 repeate 만큼 append
                for (int i = 0; i < repeate; i++) {
                    prev.append(cur);
                }
                // 새롭게 갱신된 문자열이 다음 cur
                cur = prev;
            }

            // 일반 문자면 그냥 cur에 추가
            else cur.append(c);
        }
        return cur.toString();
    }
}