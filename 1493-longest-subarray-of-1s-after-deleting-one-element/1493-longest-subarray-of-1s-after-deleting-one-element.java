class Solution { // O(n)
    public int longestSubarray(int[] nums) {
        int i = 0;
        int count = 0;
        int res = 0;

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == 0) count++;
            while (count > 1) {
                if (nums[i] == 0) count--;
                i++;
            }
            res = Math.max(j - i, res);
        }
        return res == nums.length ? res - 1 : res;
    }
}