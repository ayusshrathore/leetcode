class Solution {
    public int balancedStringSplit(String s) {
        int count = 0;
        int total = 0;

        for(char c: s.toCharArray()){
            if(c == 'R'){
                ++count;
            }

            if(c == 'L'){
                --count;
            }

            if(count == 0){
                ++total;
            }
        }
        return total;
    }
}