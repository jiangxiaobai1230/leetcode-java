package src.String;

import java.util.List;

/**
 * @author: Yuan Yuqing
 * @date: 2024-03-24 22:07
 */
public class No151 {
    public String reverseWords(String s) {
        StringBuffer sb=new StringBuffer();
        s=s.trim();
        String[] stringList=s.split(" ");
        int len=stringList.length;
        for(int i=len-1;i>=0;i--){
            if(stringList[i]!=""){
                String t=stringList[i];
                sb.append(t);
                sb.append(" ");
            }

        }

        return sb.substring(0,sb.length()-1);

    }

    public static void main(String[] args) {
        //示例 1：
        //
        //输入：s = "the sky is blue"
        //输出："blue is sky the"
        //示例 2：
        //
        //输入：s = "  hello world  "
        //输出："world hello"
        //解释：反转后的字符串中不能存在前导空格和尾随空格。
        //示例 3：
        //
        //输入：s = "a good   example"
        //输出："example good a"
        //解释：如果两个单词间有多余的空格，反转后的字符串需要将单词间的空格减少到仅有一个。
        String s ;
        No151 no151 = new No151();
        s="the sky is blue";
        System.out.println(no151.reverseWords(s));

        s="  hello world  ";
        System.out.println(no151.reverseWords(s));
        s="a good   example";
        System.out.println(no151.reverseWords(s));





    }
}
