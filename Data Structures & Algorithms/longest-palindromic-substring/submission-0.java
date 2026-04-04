class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        int resLen = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                int l = i, r = j;
                while (l < r && s.charAt(l) == s.charAt(r)) {
                    l++;
                    r--;
                }

                if (l >= r && resLen < (j - i + 1)) {
                    res = s.substring(i, j + 1);
                    resLen = j - i + 1;
                }
            }
        }
        return res;
    }
}
