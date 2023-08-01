class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        f(1, n, k, ans, new ArrayList<Integer>());
        return ans;
    }

    private void f(int start, int end, int k, List<List<Integer>> ans, List<Integer> ds) {
        if (end - start + 1 < k) {
            return;
        }
        
        if (k == 0) {
            ans.add(new ArrayList<Integer>(ds));
            return;
        }

        for (int i = start; i <= end; i++) {
            ds.add(i);
            f(i + 1, end, k - 1, ans, ds);
            ds.remove(ds.size() - 1);
        }
    }
}