class MyQueue {
    private Stack<Integer> st;

    public MyQueue() {
        st = new Stack<>();
    }
    
    public void push(int x) {
        Stack<Integer> temp = new Stack<>();
        int size = st.size();
        while (size-- > 0) {
            temp.push(st.pop());
        }
        st.push(x);
        size = temp.size();
        while (size-- > 0) {
            st.push(temp.pop());
        }
    }
    
    public int pop() {
        return st.pop();
    }
    
    public int peek() {
        return st.peek();
    }
    
    public boolean empty() {
        return st.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */