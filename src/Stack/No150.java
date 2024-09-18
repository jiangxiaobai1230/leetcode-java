package src.Stack;

import java.util.Stack;

/**
 * @author: Yuan Yuqing
 * @date: 2024-03-29 18:40
 */
public class No150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack=new Stack<>();
        int n=tokens.length;
        for(int i=0;i<n;i++){
            String s=tokens[i];
            if(s.length()>1||(s.charAt(0)>='0'&&s.charAt(0)<='9')){
                stack.push(Integer.valueOf(s));
            }else{
                int nums1=stack.pop();
                int nums2=stack.pop();
                int nums3 = 0;
                if(s.equals("+")){
                    nums3=nums2+nums1;
                } else if (s.equals("-")) {
                    nums3=nums2-nums1;

                } else if (s.equals("*")) {
                    nums3=nums2*nums1;
                }
                else if (s.equals("/")) {
                    nums3=nums2/nums1;
                }
                stack.push(nums3);
            }
        }
        return stack.peek();
    }

    public static void main(String[] args) {
        //示例 1：
        //
        //输入：tokens = ["2","1","+","3","*"]
        //输出：9
        //解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
        //示例 2：
        //
        //输入：tokens = ["4","13","5","/","+"]
        //输出：6
        //解释：该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6
        //示例 3：
        //
        //输入：tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
        //输出：22
        //解释：该算式转化为常见的中缀算术表达式为：
        //  ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
        //= ((10 * (6 / (12 * -11))) + 17) + 5
        //= ((10 * (6 / -132)) + 17) + 5
        //= ((10 * 0) + 17) + 5
        //= (0 + 17) + 5
        //= 17 + 5
        //= 22
        //


        String[] tokens = {"2","1","+","3","*"};
        No150 no150 = new No150();
        int res = no150.evalRPN(tokens);
        System.out.println(res);

        tokens=new String[]{"4","13","5","/","+"};
        res = no150.evalRPN(tokens);
        System.out.println(res);
        tokens=new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        res = no150.evalRPN(tokens);
        System.out.println(res);


    }
}
