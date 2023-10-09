class Solution {
    public void moveZeroes(int[] nums) {
        int pointer = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[pointer] = nums[i];
                pointer++;
            }
        }
        for (int i = pointer; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}