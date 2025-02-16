package src.hot100;

import java.util.Stack;

/**
 * @author: Yuan Yuqing
 * @date: 2025-02-13 21:13
 */
public class No394 {
    //https://leetcode.cn/problems/decode-string/solutions/19447/decode-string-fu-zhu-zhan-fa-di-gui-fa-by-jyd/comments/1233118
    public String decodeString(String s) {
        Stack<StringBuilder> restack = new Stack<>();
        Stack<Integer> kstack = new Stack<>();
        StringBuilder res = new StringBuilder();
        int k=0;
        for (char c:s.toCharArray()){
            if (c=='[') {
                kstack.push(k);
                restack.push(res);
                k=0;
                res=new StringBuilder();
            }
            else if(c==']'){
                int curk=kstack.pop();
                StringBuilder temp = new StringBuilder();
                for(int i = 0; i < curk; i++){
                    temp.append(res);
                }
                res=restack.pop().append(temp);
            }
            else if(c>='0'&&c<='9'){
                k=c-'0'+k*10;
            }
            else{
                res.append(c);
            }
        }
        return res.toString();

    }

    public static void main(String[] args) {
        //示例 1：
        //
        //输入：s = "3[a]2[bc]"
        //输出："aaabcbc"
        //示例 2：
        //
        //输入：s = "3[a2[c]]"
        //输出："accaccacc"
        //示例 3：
        //
        //输入：s = "2[abc]3[cd]ef"
        //输出："abcabccdcdcdef"
        //示例 4：
        //
        //输入：s = "abc3[cd]xyz"
        //输出："abccdcdcdxyz"
        String s ="3[a]2[bc]";
        No394 no394 = new No394();
        System.out.println(no394.decodeString(s));
        s="3[a2[c]]";
        System.out.println(no394.decodeString(s));
        s= "2[abc]3[cd]ef";
        System.out.println(no394.decodeString(s));
        s= "abc3[cd]xyz";
        System.out.println(no394.decodeString(s));



    }
}
