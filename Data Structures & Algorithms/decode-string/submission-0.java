class Solution {
    public String decodeString(String s) {
        // 반복 횟수 저장
        Stack<Integer> countStack = new Stack<>();
        // 이전 문자열 저장 (괄호 밖)
        Stack<StringBuilder> strStack = new Stack<>();
        // 현재 문자열
        StringBuilder cur = new StringBuilder();
        // 현재 숫자
        int num = 0;

        for (char c : s.toCharArray()) {
            // 숫자면 반복 횟수 누적
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }

            // 여는 괄호 -> 상태 저장하고 새 시작
            else if (c == '[') {
                countStack.push(num); // 반복 횟수 주정
                strStack.push(cur); // 현재 문자열 저장
                cur = new StringBuilder(); // 괄호 안 새 문자열 시작
                num = 0; // 숫자 초기화
            }

            // 닫는 괄호 -> 반복 적용
            else if (c == ']') {
                int repeat = countStack.pop(); // 반복 횟수 꺼냄
                StringBuilder prev = strStack.pop(); // 이전 문자열
                // 현재 문자열을 repeat 붙이기
                for (int i = 0; i < repeat; i++) {
                    prev.append(cur);
                }
                // 결과를 현재 문자열로 갱신
                cur = prev;
            }

            // 일반 문자 -> 그냥 붙이기
            else cur.append(c);
        }

        // 최종 결과 반환
        return cur.toString();
    }
}