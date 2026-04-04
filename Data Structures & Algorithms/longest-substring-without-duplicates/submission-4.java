class Solution {

    /*
        중복된 문자가 없는 가장 긴 부분 문자열 반환
    */
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int l = 0;
        int res = 0;
        
        for (int r = 0; r < s.length(); r++) {
            while (set.contains(s.charAt(r))) { // Slidng Window에 중복 발견
                set.remove(s.charAt(l)); // 왼쪽 문자 제거
                l++;
            }
            set.add(s.charAt(r));
            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}
