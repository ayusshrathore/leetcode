class Solution {
    public int maxVowels(String s, int k) {
        int n = s.length();
        
        int i = 0, j = 0, max = 0, count = 0;
        
        while(j < n) {
            if(isVowel(s.charAt(j)))
                count++;
            
            if((j - i) + 1 == k) {
                max = Math.max(max, count);
                
                if(isVowel(s.charAt(i)))
                    count--;
                
                i++;
            }
            
            j++;
        }
        
        return max;
    }
    public boolean isVowel(Character ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}