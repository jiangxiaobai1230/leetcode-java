package src.dp;

/**
 * @author: Yuan Yuqing
 * @date: 2024-09-19 19:17
 */
public class No72 {

    public int minDistance(String word1, String word2) {
        int len1=word1.length(),len2=word2.length();
        int[][] dp=new int[len1+1][len2+1];
        //word1 0-i-1 word2 0-j-1范围一样需要的最少步数
        for(int i=1;i<=len1;i++){
            dp[i][0]=i;
        }
        for(int i=1;i<=len2;i++){
            dp[0][i]=i;
        }
        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
            }
        }
        return dp[len1][len2];

    }

    public static void main(String[] args) {
        //示例 1：
        //
        //输入：word1 = "horse", word2 = "ros"
        //输出：3
        //解释：
        //horse -> rorse (将 'h' 替换为 'r')
        //rorse -> rose (删除 'r')
        //rose -> ros (删除 'e')
        //示例 2：
        //
        //输入：word1 = "intention", word2 = "execution"
        //输出：5
        //解释：
        //intention -> inention (删除 't')
        //inention -> enention (将 'i' 替换为 'e')
        //enention -> exention (将 'n' 替换为 'x')
        //exention -> exection (将 'n' 替换为 'c')
        //exection -> execution (插入 'u')
        No72 no72 = new No72();
        System.out.println(no72.minDistance("horse", "ros"));
        System.out.println(no72.minDistance("intention", "execution"));
    }
}
