class Solution {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

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
