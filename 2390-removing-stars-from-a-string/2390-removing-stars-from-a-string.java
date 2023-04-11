class Solution {
    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '*') {
                sb.deleteCharAt(sb.length()-1);
                continue;
            }
            
            sb.append(s.charAt(i));
        }
                
        return sb.toString();
    }
}