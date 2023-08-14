class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> ds = new ArrayList<>();
        Set<List<Integer>> ans = new HashSet<>();
        boolean[] freq = new boolean[nums.length];
        recur(nums, ds, freq, ans);
        return new ArrayList<>(ans);
    }
    
    private static void recur(int[] nums, List<Integer> ds, boolean[] freq, Set<List<Integer>> ans) {
        if (ds.size() == nums.length) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (!freq[i]) {
                freq[i] = true;
                ds.add(nums[i]);
                recur(nums, ds, freq, ans);
                ds.remove(ds.size() - 1);
                freq[i] = false;
            }
        }
    }
}