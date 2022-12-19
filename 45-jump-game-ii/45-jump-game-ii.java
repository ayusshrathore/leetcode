class Solution {
    public int jump(int[] nums) {
        int curr = 0, max = 0, count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(nums[i] + i, max);
            if (i == curr) {
                count++;
                curr = max;
            }
        }
        return count;
    }
}