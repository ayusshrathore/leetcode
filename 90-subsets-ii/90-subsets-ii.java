class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        findSubsets(0, nums, new ArrayList<>(), ans);
        return ans;
    }
    
    private void findSubsets(int idx, int[] nums, List<Integer> ds, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(ds));
        for (int i = idx; i < nums.length; i++) {
            if (i != idx && nums[i] == nums[i - 1]) continue;
            ds.add(nums[i]);
            findSubsets(i + 1, nums, ds, ans);
            ds.remove(ds.size() - 1);
        }
    }
}