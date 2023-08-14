class Solution {
    public boolean isScramble(String s1, String s2) {
        Map<String, Boolean> dp = new HashMap<>();
        return f(s1, s2, dp);
    }
    public boolean f(String s1, String s2, Map<String, Boolean> dp) {
        if(s1.length() != s2.length()) // if both string aren't of equal length (i.e they aren't equal) 
            return false;
        
        if(s1.equals(s2))
            return  true;
        
        String key = s1 + "_" + s2; // use of "_" due to these cases -> ab+cde, a+bcde (splitting isn't determined)
        
        if(dp.containsKey(key))
            return dp.get(key);
        
        boolean result = false;
        
        int n = s1.length();
        
        for(int i = 1; i < n; i++) { // spliting at random index
            // 'ab'cde, 'cd'eab
            boolean notSwap = f(s1.substring(0, i), s2.substring(0, i), dp) && f(s1.substring(i), s2.substring(i), dp);
            
            if(notSwap) {
                result = true;
                break;
            }
            // 'ab'cde cde'ab'
            boolean swap = f(s1.substring(0, i), s2.substring(n-i), dp) && f(s1.substring(i), s2.substring(0, n-i), dp);
            
            if(swap) {
                result = true;
                break;
            }
        }
        
        dp.put(key, result);
        
        return result;
    } 
}