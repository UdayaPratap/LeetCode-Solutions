/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
You must implement a solution with O(1) time complexity for each function.

 */
class MinStack {
    int min=Integer.MAX_VALUE;
    Stack<Integer> st;
    public MinStack() {
        st=new Stack();
    }
    
    public void push(int val) {
        //everytime a smaller number is pushed, push the last min before it so that it can be retrieved at the time of popping.
        if(val<=min){
            st.push(min);
            min=val;
        }
        st.push(val);
    }
    
    public void pop() {
        //if top is equal to min, that means the second min at the time of pushing was pushed just before it. Hence pop a second time and assign to min.
        if(st.pop()==min) min=st.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
