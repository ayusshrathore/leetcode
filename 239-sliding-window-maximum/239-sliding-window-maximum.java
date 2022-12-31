class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        int idx = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            // remove nums out of range k
            if (!dq.isEmpty() && dq.peek() == i - k) dq.poll();

            // remove smaller nums in range k
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i])
                dq.pollLast();

            dq.offer(i);
            // add first element of dq in res
            if (i >= k - 1) res[idx++] = nums[dq.peek()];
        }
        return res;
    }
}