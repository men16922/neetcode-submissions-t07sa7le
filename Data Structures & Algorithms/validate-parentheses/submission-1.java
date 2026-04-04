class Solution {
    public boolean isValid(String s) {
        if ((s.length() & 1) == 1) return false;
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) { // 닫는 괄호인 경우
                if (!stack.isEmpty() && stack.peek() == map.get(c)) stack.pop();
                else return false;
            } else stack.push(c);
        }
        return stack.isEmpty();
    }
}
