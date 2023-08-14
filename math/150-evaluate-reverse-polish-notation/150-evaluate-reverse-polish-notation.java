class Solution {
    public int evalRPN(String[] tokens) {
        int a, b;
        Stack<Integer> st = new Stack<Integer>();
        for (String s : tokens) {
            switch (s) {
                case "+":
                    st.add(st.pop() + st.pop());
                    break;
                case "/":
                    b = st.pop();
                    a = st.pop();
                    st.add(a / b);
                    break;
                case "*":
                    st.add(st.pop() * st.pop());
                    break;
                case "-":
                    b = st.pop();
                    a = st.pop();
                    st.add(a - b);
                    break;
                default:
                    st.push(Integer.parseInt(s));
                    break;
            }
        }
        return st.pop();
    }
}