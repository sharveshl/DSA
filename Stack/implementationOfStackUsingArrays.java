class myStack {
    int[] st;
    int top;
    int n;
    public myStack(int n) {
        // Define Data Structures
        this.st = new int[n];
        this.top = - 1;
        this.n = n;
    }

    public boolean isEmpty() {
        // check if the stack is empty
        return top== -1;
    }

    public boolean isFull() {
        // check if the stack is full
        return this.top==this.n-1;
    }

    public void push(int x) {
        // Inserts x at the top of the stack
        if(this.isFull()) return;
        this.top+=1;
        st[this.top] = x;
    }

    public void pop() {
        // Removes an element from the top of the stack
        if(this.isEmpty()) return;
        st[this.top] = 0;
        this.top-=1;
    }

    public int peek() {
        // Returns the top element of the stack
        if(isEmpty()) return -1;
        return st[this.top];
    }
}
