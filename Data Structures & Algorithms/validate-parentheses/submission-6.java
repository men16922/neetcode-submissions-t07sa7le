class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) { // 1. 닫힌 괄호인 경우
                if (stack.isEmpty()) return false;
                if (map.get(c) != stack.peek()) return false;
                stack.pop();
            } 
            else { // 2. 열린 괄호인 경우
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
