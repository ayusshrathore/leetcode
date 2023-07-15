class Solution {
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int[][]dp = new int[events.length][k + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return f(events, 0, k, 0, dp); // for first event end is 0
    }

    private int f(int[][] events, int idx, int k, int end, int[][]dp) {
        if (idx == events.length || k == 0) return 0;

        if (events[idx][0] <= end) return f(events, idx + 1, k, end, dp);

        if (dp[idx][k] != -1) return dp[idx][k];

        int take = events[idx][2] + f(events, idx + 1, k - 1, events[idx][1], dp);
        int notTake = 0 + f(events, idx + 1, k, end, dp);

        return dp[idx][k] = Math.max(take, notTake);
    }
}