class Solution { // String, TC: O(n) + O(n * m) -> O(n * m)
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        int n = words.length;
        
        StringBuilder reversed = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            String word = words[i];
            
            for (int j = word.length() - 1; j >= 0; j--) {
                reversed.append(word.charAt(j));
            }

            if (i < n - 1) {
                reversed.append(" ");
            }
        }
        
        return reversed.toString();
    }
}
