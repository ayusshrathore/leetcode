class Solution {
    public String convert(String s, int numRows) {
        if(numRows ==  1) return s;
        
        int n = s.length();
        StringBuilder sb = new StringBuilder();

        for(int row = 0; row < numRows; row++){
            int col = 2 * (numRows - 1);
            int i = row;
            while(i < n){
                sb.append(s.charAt(i));
                
                int j = i + col - 2 * row; // single characters
                if(row > 0 && row < numRows - 1 && j < n) // for middle rows
                    sb.append(s.charAt(j));
                
                i += col;
            }
        }
        return sb.toString();
    }
}