package src.String;

/**
 * @author: Yuan Yuqing
 * @date: 2024-03-23 23:30
 */
public class CMN054 {

    public String replaceNumber(String s) {
        StringBuffer sb=new StringBuffer();
        int i=0;
        int len=s.length();
        while(i!=len){
            if(s.charAt(i)>='0' &&s.charAt(i)<='9'){
                sb.append("number");
            }else{
                sb.append(s.charAt(i));
            }
            i++;

        }
        return sb.substring(0,sb.length());

    }

    public static void main(String[] args) {
        //题目描述
        //给定一个字符串 s，它包含小写字母和数字字符，请编写一个函数，将字符串中的字母字符保持不变，而将每个数字字符替换为number。 例如，对于输入字符串 "a1b2c3"，函数应该将其转换为 "anumberbnumbercnumber"。
        //输入描述
        //输入一个字符串 s,s 仅包含小写字母和数字字符。
        //输出描述
        //打印一个新的字符串，其中每个数字字符都被替换为了number
        String s = "j119kfun72k9et9izrpw9bsxhah55ovorf5ffzuyd4zir4gjdf";
        System.out.println(new CMN054().replaceNumber(s));

        s="aaq12";
        System.out.println(new CMN054().replaceNumber(s));

    }
}
