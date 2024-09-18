package src.dp;

import java.util.Arrays;

/**
 * @author: Yuan Yuqing
 * @date: 2024-09-13 16:03
 */
public class No392 {

    public boolean isSubsequence(String s, String t) {
        int len1=s.length(),len2=t.length();
        if(len1>len2)return false;
        if(s.equals(""))return true;
        if(t.equals(""))return false;
        //dp[i][j] 表示以下标i-1为结尾的字符串s，和以下标j-1为结尾的字符串t，相同子序列的长度为dp[i][j]。
        int[][] dp=new int[len1+1][len2+1];
        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                if(dp[i][j]==len1)return true;

            }
        }
        return false;
    }

    public static void main(String[] args) {
        //示例 1：
        //
        //输入：s = "abc", t = "ahbgdc"
        //输出：true
        //示例 2：
        //
        //输入：s = "axc", t = "ahbgdc"
        //输出：false

        No392 no392 = new No392();
        boolean subsequence = no392.isSubsequence("abc", "ahbgdc");
        System.out.println(subsequence);
        subsequence = no392.isSubsequence("axc", "ahbgdc");
        System.out.println(subsequence);
    }
}
