class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        for (int num : nums) set.add(num);
        int max = 0;
        
        for (int num : nums) {
          if (!set.contains(num - 1)) {
            int current = num;
            int streak = 1;

            while (set.contains(current + 1)) {
              current++;
              streak++;
            }
            max = Math.max(streak, max);
          }
        }
        return max;
    }
}