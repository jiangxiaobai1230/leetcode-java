package src.dp;

/**
 * @author: Yuan Yuqing
 * @date: 2024-09-18 20:20
 */
public class No583 {
    //// dp数组中存储word1和word2最长相同子序列的长度
    public int minDistance(String word1, String word2) {
        int len1=word1.length(),len2=word2.length();
        int[][] dp=new int[len1+1][len2+1];
        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);

            }
        }

        return len1+len2-2*dp[len1][len2];

    }

    public static void main(String[] args) {
        //示例 1：
        //
        //输入: word1 = "sea", word2 = "eat"
        //输出: 2
        //解释: 第一步将 "sea" 变为 "ea" ，第二步将 "eat "变为 "ea"
        //示例  2:
        //
        //输入：word1 = "leetcode", word2 = "etco"
        //输出：4
        No583 no583 = new No583();

        System.out.println(no583.minDistance("sea", "eat"));
        System.out.println(no583.minDistance("leetcode", "etco"));
    }
}
