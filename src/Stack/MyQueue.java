package src.Stack;

import java.util.Stack;

/**
 * @author: Yuan Yuqing
 * @date: 2024-03-27 11:43
 */
public class MyQueue {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public MyQueue() {
        stack1=new Stack();
        stack2=new Stack();

    }

    public void push(int x) {
        stack1.push(x);


    }

    public int pop() {
        int num=peek();
        stack2.pop();
        return num;


    }

    public int peek() {
        if(!stack2.empty()){
            return stack2.peek();
        }
        if(stack1.empty()){
            return -1;
        }
        while(!stack1.empty()){
            stack2.push(stack1.pop());
        }
        return stack2.peek();

    }

    public boolean empty() {
        return stack1.empty()&&stack2.empty();

    }
}
