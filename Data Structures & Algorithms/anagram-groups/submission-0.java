class Solution {
    public List<List<String>> groupAnagramsHash(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char [] arr = str.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int [] freq = new int[26];
            for (int i = 0; i < str.length(); i++) {
                freq[str.charAt(i) - 'a']++;
            }

            // 키 직렬화: 구분자 포함해 충돌 방지.
            StringBuilder sb = new StringBuilder(26 * 2);
            for (int f : freq) {
                sb.append('#').append(f);
            }
            String key = sb.toString();
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
            
        }
        return new ArrayList<>(map.values());
    }
}
