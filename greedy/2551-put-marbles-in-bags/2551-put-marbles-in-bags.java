class Solution {
    public long putMarbles(int[] weights, int k) {
        int n = weights.length;
        if (n <= k) return 0;

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            list.add(weights[i] + weights[i - 1]);
        }

        Collections.sort(list);

        long max = 0;
        long min = 0;

        for (int i = 1; i < k; i++) {
            min += list.get(i - 1);
            max += list.get(n - i - 1);
        }

        return max - min;
    }
}