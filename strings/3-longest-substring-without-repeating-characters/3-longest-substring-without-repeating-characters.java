class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = 0;
		Map<Character, Integer> map = new HashMap<>();
		int i = 0, n = s.length(), l = 0;
		while ( i < n) {
			if (map.containsKey(s.charAt(i))) 
				l = Math.max(map.get(s.charAt(i)) + 1, l);
			map.put(s.charAt(i), i);
			len = Math.max(i - l + 1, len);
			i++;
		}
		return len;
    }
}