class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = pushed.length, m = popped.length;
        Stack<Integer> st = new Stack<>();
        
        int i = 0, j = 0;
        while(i < n && j < m) {
            st.push(pushed[i]);
            
            while(!st.isEmpty() && st.peek() == popped[j] && j < m) { // verify current top of st & popped[j] (since elements are unique this will tend to work)
                st.pop();
                j++;
            }
            
            i++;
        }
        
        return st.isEmpty();
    }
}