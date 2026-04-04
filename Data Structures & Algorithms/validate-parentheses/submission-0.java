class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> bracketMap = new HashMap<>();
        bracketMap.put(')', '(');
        bracketMap.put('}', '{');
        bracketMap.put(']', '[');

        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (bracketMap.containsKey(c)) {
                if (!stack.isEmpty() && stack.peek() == bracketMap.get(c)) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}
