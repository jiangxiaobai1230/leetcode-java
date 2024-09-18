package src.Stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: Yuan Yuqing
 * @date: 2024-03-28 22:57
 */
class MyStack {
    private Queue<Integer> queue;

    public MyStack() {
        queue=new LinkedList<>();

    }

    public void push(int x) {
        int n=queue.size();
        queue.offer(x);
        while (n>0){
            queue.offer(queue.poll());
            n--;
        }
    }

    public int pop() {
        return  queue.poll();
    }

    public int top() {
        return queue.peek();

    }

    public boolean empty() {
        return queue.isEmpty();
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