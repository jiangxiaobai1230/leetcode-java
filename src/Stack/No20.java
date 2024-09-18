package src.Stack;

import java.util.Stack;

/**
 * @author: Yuan Yuqing
 * @date: 2024-03-28 23:14
 */
public class No20 {

    public boolean isValid(String s) {

        Stack stack=new Stack<>();
        stack.push('#');
        int n=s.length();
        if(n%2!=0){
            return false;
        }
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            if(c=='('||c=='['||c=='{'){
                stack.push(c);
            } else if (c==')') {
                if(stack.peek().equals('(')){
                    stack.pop();
                }else return false;

            }
            else if (c==']') {
                if(stack.peek().equals('[')){
                    stack.pop();
                }else return false;

            }
            else if (c=='}') {
                if(stack.peek().equals('{')){
                    stack.pop();
                }else return false;

            }


        }
        if(stack.peek().equals('#')){
            return true;
        }
        return false;


    }
    public static void main(String[] args) {

        //给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
        //
        //有效字符串需满足：
        //
        //左括号必须用相同类型的右括号闭合。
        //左括号必须以正确的顺序闭合。
        //每个右括号都有一个对应的相同类型的左括号。
        //
        //
        //示例 1：
        //
        //输入：s = "()"
        //输出：true
        //示例 2：
        //
        //输入：s = "()[]{}"
        //输出：true
        //示例 3：
        //
        //输入：s = "(]"
        //输出：false

        String s = "((";
        No20 no20 = new No20();
        System.out.println(no20.isValid(s));
        System.out.println(no20.isValid("()[]{}"));
        System.out.println(no20.isValid("]]"));




    }
}
