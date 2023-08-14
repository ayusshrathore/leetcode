class MyStack {
    private Queue<Integer> q1;
    private Queue<Integer> q2;
    private int top;

    public MyStack() {
        this.q1 = new ArrayDeque<>();
        this.q2 = new ArrayDeque<>();
    }
    
    public void push(int x) {
        q1.add(x);
        this.top = x;
    }
    
    public int pop() {
        while (q1.size() > 1) {
            this.top = q1.remove();
            q2.add(top);
        }
        swapQueues();
        return q2.remove();
    }
    
    public int top() {
        return this.top;
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }

    private void swapQueues() {
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */