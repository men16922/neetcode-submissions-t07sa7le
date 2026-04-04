class Solution {
    public boolean isPalindromeReverse(String s) {
        StringBuilder builder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                builder.append(Character.toLowerCase(c));
            }
        }
                
        String s1 = builder.toString();
        String s2 = new StringBuilder(s1).reverse().toString();

        return s1.equals(s2);
    }

    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;

        while (l < r) {
            char lChar = s.charAt(l);
            char rChar = s.charAt(r);

            if (!Character.isLetterOrDigit(lChar)) l++;
            else if (!Character.isLetterOrDigit(rChar)) r--;
            else {
                if (Character.toLowerCase(lChar) != Character.toLowerCase(rChar)) return false;
                l++;
                r--;
            }
        }
        return true;
    }
}
