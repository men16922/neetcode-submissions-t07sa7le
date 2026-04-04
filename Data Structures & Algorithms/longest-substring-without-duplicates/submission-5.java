class Solution {
    /*
        중복된 문자가 없는 가장 긴 부분문자열의 길이 반환

    */
    public int lengthOfLongestSubstringBruteForce(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            HashSet<Character> charSet = new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                if (charSet.contains(s.charAt(j))) break;
                charSet.add(s.charAt(j));
            }
            res = Math.max(res, charSet.size());
        }
        return res;
    }

    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> charSet = new HashSet<>();
        int l = 0; 
        int res = 0;
        for (int r = 0; r < s.length(); r++) {
            while (charSet.contains(s.charAt(r))) { // 중복문자 발견
                charSet.remove(s.charAt(l)); // 슬라이딩 윈도우 이동
                l++;
            }
            charSet.add(s.charAt(r));
            res = Math.max(res, r - l + 1); // 전체 길이
        }
        return res;
    }
}
