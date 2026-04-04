class Solution {
    public List<List<String>> groupAnagramsSorting(String[] strs) {
        // Sorting. anaram은 sorting하면 같은문자다. 같은문자끼리 묶어서 Map에 넣기
        HashMap<String, List<String>> res = new HashMap<>();
        for (String s : strs) {
            char [] sArray = s.toCharArray();
            Arrays.sort(sArray);
            String str = new String(sArray);
            res.putIfAbsent(str, new ArrayList<>());
            // Sorting된 문자열을 key로, 기존 문자열 value리스트에 추가
            res.get(str).add(s);
        }
        return new ArrayList<>(res.values());
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> res = new HashMap<>();
        for (String s : strs) {
            int [] count = new int [26]; // 영소문자 배열
            for (char c : s.toCharArray()) { // 문자열의 Character 알파벳 갯수세기
                count[c - 'a']++; // 영소문자 순서
            }
            String key = Arrays.toString(count);
            res.putIfAbsent(key, new ArrayList<>());
            res.get(key).add(s);
        }
        return new ArrayList<>(res.values());
    }
}
