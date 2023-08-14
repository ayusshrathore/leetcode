class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> st = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) st.pop();
            if (st.isEmpty()) left[i] = 0;
            else left[i] = st.peek() + 1;
            st.push(i);
        }
        
        st.clear();
        
        for (int i = n-1; i >= 0; i--) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) st.pop();
            if (st.isEmpty()) right[i] = n-1;
            else right[i] = st.peek() - 1;
            st.push(i);
        }
        
        int maxA = 0;
        for (int i = 0; i < n; i++) 
            maxA = Math.max((right[i] - left[i] + 1) * heights[i], maxA);
        
        return maxA;
    }
}