package src.String;

/**
 * @author: Yuan Yuqing
 * @date: 2024-03-26 23:13
 */
public class No459 {
    public boolean repeatedSubstringPattern(String s) {
        int lenS=s.length();
        boolean isRepeatedFlag=false;
        if (lenS == 1) {
            return false;
        }
        for(int i=1;i<lenS;i++) {
            String t=s.substring(0,i);
            isRepeatedFlag=isRepeated(s,t);
            if(isRepeatedFlag==true) {
                return isRepeatedFlag;
            }

        }
        return isRepeatedFlag;


    }
    public boolean isRepeated(String m,String n) {
        boolean isRepeatedFlag=true;
        int lenM=m.length(),lenN=n.length();
        if(lenM%lenN!=0) {
            isRepeatedFlag=false;
            return isRepeatedFlag;
        }
        for(int i=0;i<lenM/lenN;i++) {
            String t=m.substring(lenN*i,lenN*(i+1));

            if(!n.equals(t)) {
                isRepeatedFlag=false;
                return isRepeatedFlag;
            }
        }


        return isRepeatedFlag;



    }


    public static void main(String[] args) {
        //给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
        //
        //
        //
        //示例 1:
        //
        //输入: s = "abab"
        //输出: true
        //解释: 可由子串 "ab" 重复两次构成。
        //示例 2:
        //
        //输入: s = "aba"
        //输出: false
        //示例 3:
        //
        //输入: s = "abcabcabcabc"
        //输出: true
        //解释: 可由子串 "abc" 重复四次构成。 (或子串 "abcabc" 重复两次构成。)

        No459 no459 = new No459();
        System.out.println(no459.repeatedSubstringPattern("abab"));
        System.out.println(no459.repeatedSubstringPattern("aba"));
        System.out.println(no459.repeatedSubstringPattern("abcabcabcabc"));
    }


}
