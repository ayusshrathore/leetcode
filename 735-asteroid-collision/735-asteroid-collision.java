class Solution {
    public int[] asteroidCollision(int[] A) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0) st.push(A[i]);
            else {
                while (!st.isEmpty() && st.peek() > 0 && st.peek() < -A[i])
                    st.pop();
                if (!st.isEmpty() && st.peek() == -A[i])
                    st.pop();
                else if (st.isEmpty() || st.peek() < 0)
                    st.push(A[i]);
            }
        }
        int[] res = new int[st.size()];
        int idx = 0;
        for (int e : st) res[idx++] = e;
        return res;
    }
}