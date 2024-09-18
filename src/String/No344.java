package src.String;

/**
 * @author: Yuan Yuqing
 * @date: 2024-03-22 19:11
 */
public class No344 {
    public void reverseString(char[] s) {
        int len=s.length;
        for(int i=0;i<len/2;i++){
            char t=s[i];
            s[i]=s[len-1-i];
            s[len-1-i]=t;
        }

    }

    public static void main(String[] args) {
        //示例 1：
        //
        //输入：s = ["h","e","l","l","o"]
        //输出：["o","l","l","e","h"]
        //示例 2：
        //
        //输入：s = ["H","a","n","n","a","h"]
        //输出：["h","a","n","n","a","H"]
        char[] s = new char[]{'h','e','l','l','o'};
        new No344().reverseString(s);
        for (char c : s) {
            System.out.print(c);
        }
        System.out.println();

        s = new char[]{'H','a','n','n','a','h'};
        new No344().reverseString(s);
        for (char c : s) {
            System.out.print(c);
        }
    }
}
