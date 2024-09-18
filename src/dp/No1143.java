package src.dp;

/**
 * @author: Yuan Yuqing
 * @date: 2024-09-12 15:58
 */
public class No1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1=text1.length(),len2=text2.length();
        int[][] dp=new int[len1+1][len2+1];

        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
            }
        }
        return dp[len1][len2];

    }

    public static void main(String[] args) {
        //示例 1：
        //
        //输入：text1 = "abcde", text2 = "ace"
        //输出：3
        //解释：最长公共子序列是 "ace" ，它的长度为 3 。
        //示例 2：
        //
        //输入：text1 = "abc", text2 = "abc"
        //输出：3
        //解释：最长公共子序列是 "abc" ，它的长度为 3 。
        //示例 3：
        //
        //输入：text1 = "abc", text2 = "def"
        //输出：0
        //解释：两个字符串没有公共子序列，返回 0 。
        //

        No1143 no1143 = new No1143();
        System.out.println(no1143.longestCommonSubsequence("abcde", "ace"));
        System.out.println(no1143.longestCommonSubsequence("abc", "abc"));
        System.out.println(no1143.longestCommonSubsequence("abc", "def"));
    }
}
