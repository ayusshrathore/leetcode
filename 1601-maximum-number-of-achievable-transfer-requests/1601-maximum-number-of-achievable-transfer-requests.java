class Solution { // Backtracking O(2^m * n)
    
    private int result = Integer.MIN_VALUE;
    private int m;
    
    public int maximumRequests(int n, int[][] requests) {
        this.m = requests.length;
        
        int[] resultant = new int[n];
        
        solve(0, 0, resultant, requests);
        
        return result;
    }
    public void solve(int idx, int count, int[] resultant, int[][] requests) {
        
        if(idx >= m) { // out of bounds exhausted all requests
            boolean allZero = true;
            
            for(int x : resultant) {
                
                if(x != 0) {
                    allZero = false;
                    break;
                }
            }
            
            if(allZero)
                result = Math.max(result, count);
            
            return;
        }
        
        int from = requests[idx][0];
        int to = requests[idx][1];
        
        resultant[from]--; // person from building 1 -> 2
        resultant[to]++;
        
        solve(idx+1, count+1, resultant, requests); // processed the request
        
        resultant[from]++;
        resultant[to]--; // person from building 2->1 
        
        solve(idx+1, count, resultant, requests); // undo the previous process
    }
}