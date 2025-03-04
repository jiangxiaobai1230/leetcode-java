package src.hot100;

/**
 * @author: Yuan Yuqing
 * @date: 2025-03-04 13:34
 */
public class No1143 {
    //dp[i][j] 代表的是text1的0-i 和text2的0-j的公共子序列
    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length();
        int n=text2.length();
        int[][] dp=new int[m+1][n+1];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(text1.charAt(i)==text2.charAt(j)){
                    dp[i+1][j+1]=dp[i][j]+1;
                }
                else dp[i+1][j+1]=Math.max(dp[i][j+1],dp[i+1][j]);
            }
        }
        return dp[m][n];

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

        System.out.println(new No1143().longestCommonSubsequence("abcde", "ace"));
        System.out.println(new No1143().longestCommonSubsequence("abc", "abc"));
        System.out.println(new No1143().longestCommonSubsequence("abc", "def"));


    }
}
