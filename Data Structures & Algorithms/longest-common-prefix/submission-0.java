class Solution {
    public String longestCommonPrefix(String[] strs) {
        // 1. Edge case 처리
        if (strs == null || strs.length == 0) return "";

        // 2. 첫 번째 문자열을 초기 prefix로 설정
        String prefix = strs[0];

       // 3. 나머지 문자열들과 차례대로 비교 (Horizontal Scanning)
        for (int i = 1; i < strs.length; i++) {
                // 현재 strs[i]에서 prefix가 발견될 때까지 prefix를 줄여나감
                while (strs[i].indexOf(prefix) != 0) {
                    prefix = prefix.substring(0, prefix.length() - 1);
                    // 공통 접두사가 없으면 즉시 반환
                    if (prefix.isEmpty()) return "";
                }
        }
       return prefix;
    }
}