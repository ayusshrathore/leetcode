class Solution {
    public int maxVowels(String s, int k) {
        int n = s.length();
        
        Set<Character> st = Set.of('a', 'e', 'i', 'o', 'u');
        
        int i = 0, j = 0, max = 0, count = 0;
        while(i < n) {
            while(j < n && (j - i) + 1 <= k) { // increase window size till it's less than <= k
                if(st.contains(s.charAt(j))) 
                    count++;
                
                j++;
            }
            max = Math.max(max, count);
            
            if(st.contains(s.charAt(i))) // since shifting i >> right (the left corner of window might be pointing to a vowel, if so decrement it)
                count--;
            
            i++;
        }
        return max;
    }
}