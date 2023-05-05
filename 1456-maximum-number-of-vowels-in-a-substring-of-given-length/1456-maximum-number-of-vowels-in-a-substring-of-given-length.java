class Solution {
    public int maxVowels(String s, int k) {
        int n = s.length();
        
        Set<Character> st = Set.of('a', 'e', 'i', 'o', 'u');
        
        int i = 0, j = 0, max = 0, count = 0;
        while(i < n) {
            while(j < n) {
                if(((j - i) + 1) > k) 
                    break;
                
                if(st.contains(s.charAt(j))) 
                    count++;
                
                j++;
            }
            max = Math.max(max, count);
            
            if(st.contains(s.charAt(i)))
                count--;
            
            i++;
        }
        return max;
    }
}