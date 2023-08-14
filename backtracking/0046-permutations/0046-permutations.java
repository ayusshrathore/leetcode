class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> ds = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] freq = new boolean[nums.length];
        recur(nums, ds, freq, ans);
        return ans;
    }
    
    private static void recur(int[] nums, List<Integer> ds, boolean[] freq, List<List<Integer>> ans) {
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