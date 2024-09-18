package src.DoubleLink;

/**
 * @author: Yuan Yuqing
 * @date: 2024-03-27 10:56
 */
public class No151 {
    public String reverseWords(String s) {
        int fast=0,low=s.length()-1;
        StringBuffer sb=new StringBuffer();

        //去除首位空字符串
        while(s.charAt(low)==' '){
            low--;
        }
        while(s.charAt(fast)==' '){
            fast++;
        }
        s=s.substring(fast,low+1);
        fast=s.length()-1;
        low=fast;
        while(fast>=0){
            while(fast>0&&s.charAt(fast)!=' '){
                fast--;

            }
            if(s.charAt(fast)==' '|| fast==0){
                if(fast>0){
                    sb.append(s.substring(fast+1,low+1));
                    sb.append(' ');
                }
                else{
                    sb.append(s.substring(fast,low+1));

                }
                fast--;
                while (fast>=0&&s.charAt(fast)==' '){
                    fast--;
                }
                low=fast;
            }

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        //给你一个字符串 s ，请你反转字符串中 单词 的顺序。
        //
        //单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
        //
        //返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
        //
        //
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


        String s="the sky is blue";
        No151 no151=new No151();
        System.out.println(no151.reverseWords(s));
        s="  hello world  ";
        System.out.println(no151.reverseWords(s));
        s="a good   example";
        System.out.println(no151.reverseWords(s));






    }
}
