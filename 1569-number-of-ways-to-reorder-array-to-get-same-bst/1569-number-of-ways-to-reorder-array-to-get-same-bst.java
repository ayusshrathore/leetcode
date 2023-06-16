class Solution {
    Long MOD = (long)1e9+7;
    int[][] PT = new int [1001][1001]; // Pascals Table -> We can make use of Pascal's traingle to precompute combinations

    public int numOfWays(int[] nums) {
        List<Integer> arr = Arrays.stream(nums).boxed().collect(Collectors.toList());
        int n = arr.size();
        
        PT[0][0] = 1;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                PT[i][0] = 1;
                PT[i][j] = (int) ((PT[i - 1][j] + PT[i - 1][j - 1]) % MOD);
            }
        }
        
        return solve(arr) - 1;
    }
    public int solve(List<Integer> nums) {
        int n = nums.size();
        
        if(n < 3) // corner case
            return 1;
        
        List<Integer> leftArr = new ArrayList<>();
        List<Integer> rightArr = new ArrayList<>();
        
        int root = nums.get(0);
        
        for(int i = 1; i < n; i++) {
            
            if(nums.get(i) < root) {
                leftArr.add(nums.get(i)); // element smaller than root goes left
            }
            else {
                rightArr.add(nums.get(i));
            }
            
        }
        
        long x = solve(leftArr) % MOD;
        long y = solve(rightArr) % MOD;
        
        long z = PT[n-1][leftArr.size()] % MOD; // nCr = (n-1)C(leftArr.size()), n-1 -> 1 pos is fixed for root
            
        return (int)((((x * y) % MOD * z)) % MOD);
    }
}