class Solution { // classic sliding window
    public int maxVowels(String s, int k) {
        int n = s.length();
        
        int i = 0, j = 0, max = 0, count = 0;
        
        Set<Character> st = Set.of('a', 'e', 'i', 'o', 'u');
        
        while(j < n) {
            if(st.contains(s.charAt(j)))
                count++;
            
            if((j - i) + 1 == k) { // till the window size <= k
                max = Math.max(max, count);
                
                if(st.contains(s.charAt(i))) // while shifting the window >> rightif left edge of the window contains a vowel decrement the noOfVowels seen so far
                    count--;
                
                i++;
            }
            
            j++;
        }
        
        return max;
    }
}