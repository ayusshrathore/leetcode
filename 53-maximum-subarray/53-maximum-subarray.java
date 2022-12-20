class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        int start = 0;
        List<Integer> subArray = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
          sum += nums[i];
          if (sum > maxSum) {
            maxSum = sum;
            subArray.clear();
            subArray.add(start);
            subArray.add(i);
          }
          if (sum < 0) {
            sum = 0;
            start = i + 1;
          }
        }
        return maxSum;
    }
}