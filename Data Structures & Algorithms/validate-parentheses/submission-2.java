class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 1. 닫힌 괄호인 경우
            if (map.containsKey(c)) {
                if (stack.isEmpty()) return false; // 열린 괄호가 없는 경우 false
                if (map.get(c) != stack.peek()) return false; // 괄호가 매칭되지 않는 경우 false
                stack.pop();
            } else { // 2. 열린 괄호인 경우
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
