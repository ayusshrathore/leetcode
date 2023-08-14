class Solution {
    public boolean buddyStrings(String s, String goal) {
        if(s.length() != goal.length())
            return false;
        
        if(s.equals(goal)) {
            return checkFreq(s);
        }
        
        List<Integer> index = new ArrayList<>();
        
        for(int i = 0; i < s.length(); i++) {
            
            if(s.charAt(i) != goal.charAt(i))
                index.add(i);
        }
        
        if(index.size() != 2)
            return false;
        
        // swapping characters
        StringBuilder sb = new StringBuilder(s);
        sb.setCharAt(index.get(0), s.charAt(index.get(1)));
        sb.setCharAt(index.get(1), s.charAt(index.get(0)));

        return sb.toString().equals(goal);
    }
    public boolean checkFreq(String s) {
        int[] arr = new int[26];
        
        for(char ch : s.toCharArray()) {
            
            arr[ch - 'a']++;
            
            if(arr[ch - 'a'] > 1)
                return true;
        }
        
        return false;
    }
}