package src.hot100;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

/**
 * @author: Yuan Yuqing
 * @date: 2025-02-13 21:01
 */
//https://leetcode.cn/problems/min-stack/solutions/2974438/ben-zhi-shi-wei-hu-qian-zhui-zui-xiao-zh-x0g8/
public class MinStack {
    // 注意不要使用 Stack 类，因为它继承自 Vector，是同步的，会导致一些性能问题
    private final Deque<int[]> st = new ArrayDeque<>();

    public MinStack() {
        st.push(new int[]{0,Integer.MAX_VALUE});
    }

    public void push(int val) {
        st.push(new int[]{val, Math.min(getMin(),val)});

    }

    public void pop() {
        st.pop();

    }

    public int top() {
        return st.peek()[0];
    }

    public int getMin() {
        return st.peek()[1];

    }

    public static void main(String[] args) {
        //示例 1:
        //
        //输入：
        //["MinStack","push","push","push","getMin","pop","top","getMin"]
        //[[],[-2],[0],[-3],[],[],[],[]]
        //
        //输出：
        //[null,null,null,null,-3,null,0,-2]
        //
        //解释：
        //MinStack minStack = new MinStack();
        //minStack.push(-2);
        //minStack.push(0);
        //minStack.push(-3);
        //minStack.getMin();   --> 返回 -3.
        //minStack.pop();
        //minStack.top();      --> 返回 0.
        //minStack.getMin();   --> 返回 -2.
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin();
        minStack.pop();
        minStack.top();
        minStack.getMin();

    }
}
