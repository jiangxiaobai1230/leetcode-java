package src.hot100;

import java.util.Stack;

/**
 * @author: Yuan Yuqing
 * @date: 2025-03-05 00:15
 */
public class No20 {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        char[] c=s.toCharArray();
        for(int i=0;i<c.length;i++){
            if(c[i]=='('||c[i]=='{'||c[i]=='['){
                stack.push(c[i]);
            }else {
                if(c[i]==')'){
                    if (!stack.isEmpty()&&stack.peek()!='('){
                        return false;
                    }
                    if(stack.isEmpty())return false;
                    stack.pop();
                }
                else if(c[i]==']'){
                    if (!stack.isEmpty()&&stack.peek()!='['){
                        return false;
                    }
                    if(stack.isEmpty())return false;
                    stack.pop();
                }
                else if(c[i]=='}'){
                    if (!stack.isEmpty()&&stack.peek()!='{'){
                        return false;
                    }
                    if(stack.isEmpty())return false;
                    stack.pop();
                }
                else return false;
            }
        }
        if(!stack.isEmpty())return false;
        return true;

    }

    public static void main(String[] args) {
        //示例 1：
        //
        //输入：s = "()"
        //
        //输出：true
        //
        //示例 2：
        //
        //输入：s = "()[]{}"
        //
        //输出：true
        //
        //示例 3：
        //
        //输入：s = "(]"
        //
        //输出：false
        //
        //示例 4：
        //
        //输入：s = "([])"
        //
        //输出：true

        String s1 = "([)";
        String s2 = "()[]{}";
        String s3 = "(]";
        String s4 = "([])";
        No20 no20 = new No20();
        System.out.println(no20.isValid(s1));
        System.out.println(no20.isValid(s2));
        System.out.println(no20.isValid(s3));
        System.out.println(no20.isValid(s4));

    }
}
