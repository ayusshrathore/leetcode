class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;

        int total = Arrays.stream(nums).sum();
        int minSum = kadanesMin(nums, n);
        int maxSum = kadanesMax(nums, n);
        int circularSum = total - minSum;
        
        if (maxSum > 0) return Math.max(maxSum, circularSum);
        return maxSum;
    }

    private static int kadanesMin(int[] nums, int n) {
        int sum = nums[0], minSum = nums[0];
        for (int i = 1; i < n; i++) {
            sum = Math.min(sum + nums[i], nums[i]);
            minSum = Math.min(minSum, sum);
        }
        return minSum;
    }

    private static int kadanesMax(int[] nums, int n) {
        int sum = nums[0], maxSum = nums[0];
        for (int i = 1; i < n; i++) {
            sum = Math.max(sum + nums[i], nums[i]);
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}