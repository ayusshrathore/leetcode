class Solution {
    public int longestSubsequence(int[] nums, int difference) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int res = 1;

        for (int num : nums) {
            map.put(num, map.getOrDefault(num - difference, 0) + 1);
            res = Math.max(res, map.get(num));
        }

        return res;
    }
}