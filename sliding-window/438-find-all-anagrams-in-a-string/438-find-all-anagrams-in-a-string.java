class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] freqS = new int[26];
        int[] freqP = new int[26];
        int n = s.length(), m = p.length();
        if (m > n) return res;

        for (int i = 0; i < m; i++) {
            freqS[s.charAt(i) - 'a']++;
            freqP[p.charAt(i) - 'a']++;
        }

        for (int i = 0; i <= n - m; i++) {
            if (freqMatch(freqS, freqP)) res.add(i);
            freqS[s.charAt(i) - 'a']--;
            if (i + m < n) freqS[s.charAt(i + m) - 'a']++;
        }
        return res;
    }

    private boolean freqMatch(int[] arr1, int[] arr2) {
        for (int i = 0; i < 26; i++) 
            if (arr1[i] != arr2[i]) return false;
        
        return true;
    }
}