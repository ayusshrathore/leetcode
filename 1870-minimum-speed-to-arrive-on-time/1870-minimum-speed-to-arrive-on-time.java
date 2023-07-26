class Solution { // O(n * log n)
    public int minSpeedOnTime(int[] dist, double hour) {
        int low = 1, high = 10000000;

        while(low <= high) {
            int mid = (low + high) / 2;
            
            // if total time is less than given time then increase the speed, but remember overspeeding kills
            if (check(dist, mid) <= hour) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        // if maximum available speed is reached then answer is -1 and we cannot reach in given time
        return low == 10000001 ? -1 : low;
    } 

    private double check(int[] dist, int mid) {
        int n = dist.length;
        double total = 0;
        for (int i = 0; i < n; i++) {
            double time = (double) dist[i] / (double) mid;
            total += (i == n - 1 ? time : Math.ceil(time)); // round off the hover for every destination (because the next train departs at integer hour) except for last index as there are no available destinations after that
        }
        return total;
    }
}