class Solution { // (BackTracking), TC: O(2^n)
    private List<List<Integer>> res;
    
    public List<List<Integer>> combine(int n, int k) {
        this.res = new ArrayList<>();
        
        solve(n, k, 1, new ArrayList<>());
        
        return res;
    }
    private void solve(int n, int k, int idx, List<Integer> tmp) { 
        if(k == 0) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        
        // Prune the search space if there are not enough elements remaining to form a combination of size 'k'
        if (n - idx + 1 < k) {
            return;
        }
        
        tmp.add(idx);
        solve(n, k-1, idx+1, tmp);
        
        tmp.remove(tmp.size()-1);
        solve(n, k, idx+1, tmp);
    }
}