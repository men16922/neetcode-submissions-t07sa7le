class Solution {
    public boolean isAnagramSort(String s, String t) {
        char [] sArray = s.toCharArray();
        char [] tArray = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        return Arrays.equals(sArray, tArray);
    }

    public boolean isAnagram(String s, String t) {
        int [] count = new int [26];
        for (char x : s.toCharArray()) count[x - 'a']++;
        for (char x : t.toCharArray()) count[x - 'a']--;
        for (int val : count) if (val != 0) return false;
        return true;
    }
}
