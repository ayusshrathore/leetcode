class Solution { // O(26 * 26 * n (length of string)) -> O(n), space complexity -> O(1)
    public int largestVariance(String s) {
        int[] count = new int[26];
        
        for(int i = 0; i < s.length(); i++) {
            count[s.charAt(i)-'a'] = 1;
        }
        
        int result = 0;
        
        for(char first = 'a'; first <= 'z'; first++) {
            for(char second = 'a'; second <= 'z'; second++) {
                
                if(count[first-'a'] == 1 && count[second-'a'] == 1) { // both characters are present in the string
                    int firstCount = 0; // f1
                    int secondCount = 0; // f2
                    
                    boolean isSecondElementSeen = false;
                    
                    for(int i = 0; i < s.length(); i++) {
                        if(s.charAt(i) == first)
                            firstCount++;
                        
                        if(s.charAt(i) == second)
                            secondCount++;
                        
                        if(secondCount > 0) {
                            result = Math.max(result, firstCount-secondCount);
                        } else {
                            if(isSecondElementSeen) { // second Element is seen in past but count is reset due to -ve resultant
                                result = Math.max(result, firstCount-1);
                            }
                        }
                        
                        if(secondCount > firstCount) {
                            firstCount = 0;
                            secondCount = 0;
                            isSecondElementSeen = true; // element is seen, but it's count is marked 0 since freq (variance) can't be -ve
                        }
                    }
                }
            }
        }
        
        return result;
    }
}