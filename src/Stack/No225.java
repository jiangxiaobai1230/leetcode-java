package src.Stack;

/**
 * @author: Yuan Yuqing
 * @date: 2024-03-28 22:57
 */
public class No225 {


    public static void main(String[] args) {
        //示例：
        //
        //输入：
        //["MyStack", "push", "push", "top", "pop", "empty"]
        //[[], [1], [2], [], [], []]
        //输出：
        //[null, null, null, 2, 2, false]
        //
        //解释：
        //MyStack myStack = new MyStack();
        //myStack.push(1);
        //myStack.push(2);
        //myStack.top(); // 返回 2
        //myStack.pop(); // 返回 2
        //myStack.empty(); // 返回 False


        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());

    }
}
