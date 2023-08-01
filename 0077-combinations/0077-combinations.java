class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        f(1, n, k, new ArrayList<Integer>(), res);
        return res;
    }

    private void f(int idx, int n, int k, List<Integer> list, List<List<Integer>> res) {
        if (k == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = idx; i <= n - k + 1; i++) {
            list.add(i);
            f(i + 1, n, k - 1, list, res);
            list.remove(list.size() - 1);
        }
    }
}