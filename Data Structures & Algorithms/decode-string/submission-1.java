class Solution {
    public String decodeString(String s) {
        // 스택 하나에 문자, 숫자, 문자열 모두 문자열 형태로 저장
        Stack<String> stack = new Stack<>();

        // 문자열을 한 문자씩 순회
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // ']'가 나오기 전에는 push
            // 숫자 / 문자 / '[' 모두 push
            if (ch != ']') stack.push(String.valueOf(ch));

            //']'를 만나면 하나의 블록을 완성해서 디코딩
            else {
                // 1) '[]' 안의 문자열을 꺼내기 위한 StringBuilder
                StringBuilder substr = new StringBuilder();

                // 스택에서 '['를 만날 때까지 pop해서 문자들을 역순으로 모은다
                while (!stack.peek().equals("[")) {
                    substr.insert(0, stack.pop());
                }

                // '[' 제거
                stack.pop();

                // 2) '[' 앞의 반복 횟수(k) 추출
                StringBuilder k = new StringBuilder();

                // 숫자들은 연속해서 들어올 수 있으므로 전부 모아야 한다
                // 역순으로 들어가 있으니 앞에 insert
                while (!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))) {
                    k.insert(0, stack.pop());
                }

                // 숫자 문자열 -> 정수 반환
                int count = Integer.parseInt(k.toString());

                // 3) substr을 count번 반복하여 새 문자열 생성
                String repeatedStr = substr.toString().repeat(count);

                // 반복된 문자열을 다시 스택에 push
                stack.push(repeatedStr);
            }
        }

        // 스택에 남아있는 문자열들을 모두 합쳐 최종 결과 생성
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.insert(0, stack.pop());
        }
        return res.toString();
    }
}