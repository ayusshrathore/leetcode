class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        f(0, nums.length, nums, ans, new ArrayList<Integer>());
        return ans;
    }

    private void f(int start, int end, int[] nums, List<List<Integer>> ans, List<Integer> ds) {
        ans.add(new ArrayList<Integer>(ds));
        for (int i = start; i < end; i++) {
            ds.add(nums[i]);
            f(i + 1, end, nums, ans, ds);
            ds.remove(ds.size() - 1);
        }
    }
}