class Solution {
    /**
        문제 정의
            문자열 s, t가 주어질 때, t에 포함된 모든 문자(중복포함)를 포함하는 s의 가장 짧은 부분 문자열을 찾는다.
            없으면 ""를 반환한다.
            s,t는 대소문자 영어, 길이는 1 ~ 1000
        
        접근 방법
            브루트 포스로 할 경우, O(N^2)가 된다. 모든 조합을 다 봐야해서 효율적이지 않음
            Sliding Window 사용. 필요한 만큼만 본다.
        
        시간복잡도
            O(N) : s문자열 길이 + t문자열 길이
        공간복잡도
            O(1) : 상수. 알파벳 빈도수 배열

    */
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        int[] freq = new int[128];
        for (char c : t.toCharArray()) {
            freq[c]++;
        }

        int lo = 0; // left 포인터
        int hi = 0; // right 포인터
        int cnt = t.length(); // 총 글자 개수
        int minLen = Integer.MAX_VALUE; // 가장 짧은 길이
        int start = 0; // 시작 인덱스

        while (hi < s.length()) {
            char c = s.charAt(hi++);
            if (freq[c] > 0) cnt--;
            freq[c]--;
            while (cnt == 0) {
                if (hi - lo < minLen) {
                    minLen = hi - lo;
                    start = lo;
                }
                char left = s.charAt(lo++);
                if (freq[left] == 0) cnt++;
                freq[left]++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen); 
    }
}
