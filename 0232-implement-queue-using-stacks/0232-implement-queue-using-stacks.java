
class MyQueue {
    int front , rear;
    int a[];
    public MyQueue() {
        a=new int[101];
        front=rear=-1;
    }
    
    public void push(int x) {
        rear++;
        a[rear]=x;

        if(rear==0)
        front++;

    }
    
    public int pop() {
        int temp=a[front];
        front++;
        return temp;

    }
    
    public int peek() {
        return a[front];
    }
    
    public boolean empty() {
        if(front<0 || front > rear)
        return true ;
        else
        return false;
        
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