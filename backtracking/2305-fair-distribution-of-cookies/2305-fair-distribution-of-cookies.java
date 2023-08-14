class Solution { // DP - BackTracking O(k^n)
    private int res;
    
    public int distributeCookies(int[] cookies, int k) {
        int[] children = new int[k];
        res = Integer.MAX_VALUE;
        
        solve(0, cookies, k, children);
        
        return res;
    }
    public void solve(int idx, int[] cookies, int k, int[] children) {
        
        if(idx >= cookies.length) { // all cookies exhausted
            int unfairness = Arrays.stream(children).max().getAsInt();
            res = Math.min(res, unfairness);
            return;
        }
        
        int cookie = cookies[idx];
        
        for(int i = 0; i < k; i++) { // try distributing this cookie to each children
            children[i] += cookie;
            solve(idx+1, cookies, k, children);
            children[i] -= cookie; // take back cookie
            
            if(children[i] == 0)
                break;
        }
    }
}