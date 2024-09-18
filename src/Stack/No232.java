package src.Stack;

/**
 * @author: Yuan Yuqing
 * @date: 2024-03-27 11:42
 */
public class No232 {

    public static void main(String[] args) {

        // * Your MyQueue object will be instantiated and called as such:
        // * MyQueue obj = new MyQueue();
        // * obj.push(x);
        // * int param_2 = obj.pop();
        // * int param_3 = obj.peek();
        // * boolean param_4 = obj.empty();
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        int para=myQueue.pop();
        System.out.println(para);
        int para2=myQueue.peek();
        System.out.println(para2);
        boolean para3=myQueue.empty();



        //示例 1：
        //
        //输入：
        //["MyQueue", "push", "push", "peek", "pop", "empty"]
        //[[], [1], [2], [], [], []]
        //输出：
        //[null, null, null, 1, 1, false]
        //
        //解释：
        myQueue = new MyQueue();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        myQueue.peek(); // return 1
        myQueue.pop(); // return 1, queue is [2]
        myQueue.empty(); // return false






    }
}
