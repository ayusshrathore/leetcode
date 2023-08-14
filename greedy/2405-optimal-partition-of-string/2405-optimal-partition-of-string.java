class Solution { // sliding window (where max window length will represent number of unique characters it can hold)
    public int partitionString(String s) {
        int n = s.length();
                
        Set<Character> st = new HashSet<>();
        
        int res = 1; // at least 1 substring is necessary (which is the entire string)
        for(int i = 0; i < n; i++) {            
            if(st.contains(s.charAt(i))) { // if we have seen that character in past then 1 extra split required!
                st.clear();
                res++;
            }
            
            st.add(s.charAt(i));
        }
        
        return res;
    }
}
