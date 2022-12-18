class Solution {
    public String longestPalindrome(String s) {
        String longest = "";
        for (int i=0; i<s.length(); i++) {
            String temp = expand(s, i, i);
            if (temp.length() > longest.length()) longest = temp;
            temp = expand(s, i, i + 1);
            if (temp.length() > longest.length()) longest = temp;
        }
        return longest;
    }
    
    static String expand(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        return s.substring(start + 1, end);
    }
}