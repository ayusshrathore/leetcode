class Solution { // O(n * logn)
    public long maxRunTime(int n, int[] batteries) {
        long sum = 0;
        for (int battery : batteries) {
            sum += battery;
        }

        long low = 1, high = sum / n;

        while (low < high) {
            long target = high - (high - low) / 2;
            long extra = 0;

            for (int battery : batteries) {
                // finding the extra battery which cannot be used by the computers
                extra += Math.min(battery, target);
            }

            // if the extra battery is greater than the batter we took into no. of computers then we shift the low to right
            if (extra >= (long) (n * target)) {
                low = target;
            } else {
                high = target - 1;
            }
        }
        return low;
    }
}