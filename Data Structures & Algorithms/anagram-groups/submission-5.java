class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>(); // Sorted String으로 묶기 위한 map
        for (String s : strs) {
            int [] count = new int [26]; // 영소문자
            for (char c : s.toCharArray()) {
                count[c - 'a']++; // 영소문자 알파벳별 개수
            }
            String key = Arrays.toString(count); // 알파벳별 개수 배열을 key로
            res.putIfAbsent(key, new ArrayList<>());
            res.get(key).add(s);
        }
        return new ArrayList<>(res.values());
    }
}
