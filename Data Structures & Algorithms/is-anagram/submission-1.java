class Solution {
    public boolean isAnagramSort(String s, String t) {
        char [] sArray = s.toCharArray();
        char [] tArray = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        return Arrays.equals(sArray, tArray);
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int [] counts = new int [26];
        
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
            counts[t.charAt(i) - 'a']--;
        }

        for (int cnt : counts) {
            if (cnt != 0) return false;
        }
        return true;
    }
}
