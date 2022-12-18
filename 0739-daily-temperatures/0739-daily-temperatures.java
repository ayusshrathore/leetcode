class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int[] ans = new int[temp.length];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < temp.length; i++) {
            while (!st.isEmpty() && temp[i] > temp[st.peek()]) {
                int idx = st.pop();
                ans[idx] = i - idx;
            }
            st.push(i);
        }
        return ans;
    }
}