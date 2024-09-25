package src.dp;

/**
 * @author: Yuan Yuqing
 * @date: 2024-09-25 21:14
 */
public class No516 {

    public int longestPalindromeSubseq(String s) {
        int len=s.length();
        int[][] dp=new int[len][len];
        for(int i=len-1;i>=0;i--){
            dp[i][i]=1;
            for(int j=i+1;j<len;j++){
                if(s.charAt(i)==s.charAt(j)){
                    dp[i][j]=dp[i+1][j-1]+2;
                }else dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);

            }
        }
        return dp[0][len-1];

    }

    public static void main(String[] args) {
        //示例 1：
        //
        //输入：s = "bbbab"
        //输出：4
        //解释：一个可能的最长回文子序列为 "bbbb" 。
        //示例 2：
        //
        //输入：s = "cbbd"
        //输出：2
        //解释：一个可能的最长回文子序列为 "bb" 。
        No516 no516 = new No516();
        System.out.println(no516.longestPalindromeSubseq("bbbab"));
        System.out.println(no516.longestPalindromeSubseq("cbbd"));
    }

}
