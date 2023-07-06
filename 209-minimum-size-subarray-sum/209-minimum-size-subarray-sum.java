class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        int j = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            while (sum >= target) {
                sum -= nums[j];
                res = Math.min(res, i - j + 1);
                j++;
            }
        }
        if (res == Integer.MAX_VALUE) {
            return 0;
        }
        return res;
    }
}