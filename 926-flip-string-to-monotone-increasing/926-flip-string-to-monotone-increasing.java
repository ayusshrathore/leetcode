class Solution {
    public int minFlipsMonoIncr(String s) {
        int res = 0, count = 0;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '0') res = Math.min(count, res + 1);
            else count++;
        }
        return res;
    }
}