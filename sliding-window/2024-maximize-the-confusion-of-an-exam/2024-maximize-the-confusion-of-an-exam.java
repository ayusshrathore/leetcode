class Solution { // Single pass sliding window
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int result = 0, n = answerKey.length();
        
        int i = 0, j = 0;
        
        Map<Character, Integer> mp = new HashMap<>();
        
        while(j < n) {
            
            mp.put(answerKey.charAt(j), mp.getOrDefault(answerKey.charAt(j), 0) + 1); // maintain the freq of 'T' Or 'F'
            
            while(Math.min(mp.getOrDefault('F', 0), mp.getOrDefault('T', 0)) >  k) { // since we want to utilize min of k for flipping
                mp.put(answerKey.charAt(i), mp.get(answerKey.charAt(i))-1);
                i++;
            }
            
            result = Math.max(result, j-i+1);
            j++;
        }
        
        return result;
    }
}