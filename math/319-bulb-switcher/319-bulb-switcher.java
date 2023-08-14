class Solution {
    public int bulbSwitch(int n) {
        // // if n = 16, then out of (1,16), (2,8), (4,4), (8,2) and (16,1) (4, 4) being odd one out will cause the bulb to be in on state
        return (int) Math.sqrt(n);  
    }
}