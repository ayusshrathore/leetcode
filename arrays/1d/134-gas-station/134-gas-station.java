class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int max = Integer.MAX_VALUE, sum = 0, res = 0;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            if (sum < max) {
                max = sum;
                res = i + 1;
            }
        }
        return (sum < 0) ? -1 : (res % gas.length);
    }
}