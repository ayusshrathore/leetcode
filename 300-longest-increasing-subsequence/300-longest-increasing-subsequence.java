class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length+1][nums.length+1];
        for (int[] row : dp) Arrays.fill(row, -1);
        return f(0, -1, nums, dp);
    }

    public int f(int idx, int prev_idx, int[] nums, int[][] dp) {
        if (idx == nums.length) return 0;

        if (dp[idx][prev_idx + 1] != -1) return dp[idx][prev_idx + 1];

        int notPick = 0 + f(idx + 1, prev_idx, nums, dp);
        int pick = Integer.MIN_VALUE;
        if (prev_idx == -1 || nums[idx] > nums[prev_idx])
            pick = 1 + f(idx + 1, idx, nums, dp);

        return dp[idx][prev_idx + 1] = Math.max(notPick, pick);
    }
}