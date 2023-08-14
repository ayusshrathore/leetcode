class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        f(res, ds, nums, 0);
        return res;
    }

    private static void f(List<List<Integer>> res, List<Integer> ds, int[] nums, int idx) {
        if (ds.size() > 1) res.add(new ArrayList<>(ds));

        Set<Integer> set = new HashSet<>();

        for (int i = idx; i < nums.length; i++) {
            if ((ds.isEmpty() || nums[i] >= ds.get(ds.size() - 1)) && (!set.contains(nums[i]))) {
                ds.add(nums[i]);
                f(res, ds, nums, i + 1);
                ds.remove(ds.size() - 1);

                set.add(nums[i]);
            }
        }
    }
}