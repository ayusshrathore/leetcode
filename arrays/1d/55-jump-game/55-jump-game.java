class Solution {
    public boolean canJump(int[] nums) {
        int j = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i > j) return false;
            j = Math.max(j, i + nums[i]);
        } 
        return true;
    }
}